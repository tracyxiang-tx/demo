package com.tracy.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tracy.test.entity.Blog;
import com.tracy.test.entity.User;
import com.tracy.test.service.BlogServiceI;
import com.tracy.test.service.UserServiceI;


@Controller
public class BlogController {


	// 自动装配数据库接口，不需要再写原始的Connection来操作数据库
	@Autowired
	private BlogServiceI blogService;

	@Autowired
	private UserServiceI userService;

	@RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
	public String getblogs(ModelMap modelMap) {
		// 查询blog表中所有记录
		// 获取所有博客的信息
		List<Blog> blogList = blogService.getAllBlog();

		// 将所有记录传递给要返回的jsp页面，放在blogList当中
		modelMap.addAttribute("blogList", blogList);
		
		// 返回pages目录下的admin/blogs.jsp页面
		return "admin/blogs";
	}

	 // 添加博文
    @RequestMapping(value = "/admin/blogs/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
        List<User> userList = userService.getAllUser();
        // 向jsp注入用户列表
        modelMap.addAttribute("userList", userList);
        return "admin/addBlog";
    }

    // 添加博文，POST请求，重定向为查看博客页面
    @RequestMapping(value = "/admin/blogs/addBlog", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") Blog blogEntity) {
       
        // 存库
        blogService.addBlog(blogEntity);
        // 重定向地址
        return "redirect:/admin/blogs";
    }
    
 // 查看博文详情，默认使用GET方法时，method可以缺省
    @RequestMapping("/admin/blogs/show/{id}")
    public String showBlog(@PathVariable("id") int id, ModelMap modelMap) {
        Blog blog = blogService.selectByPrimaryKey(id);
        User user = userService.selectByPrimaryKey(blog.getUserId());
        blog.setUser(user);
        modelMap.addAttribute("blog", blog);
        return "admin/blogDetail";
    }
    
    
 // 修改博文内容，页面
    @RequestMapping("/admin/blogs/update/{id}")
    public String updateBlog(@PathVariable("id") int id, ModelMap modelMap) {
        // 是不是和上面那个方法很像
        Blog blog = blogService.selectByPrimaryKey(id);
        User user = userService.selectByPrimaryKey(blog.getUserId());
        blog.setUser(user);
        
        List<User> userList = userService.getAllUser();
        
        modelMap.addAttribute("blog", blog);
        modelMap.addAttribute("userList", userList);
        return "admin/updateBlog";
    }

    // 修改博客内容，POST请求
    @RequestMapping(value = "/admin/blogs/updateBlog", method = RequestMethod.POST)
    public String updateBlogP(@ModelAttribute("blogP") Blog blogEntity) {
        // 更新博客信息
    	/*blogService.updateBlog(blogEntity.getTitle(), blogEntity.getUserByUserId().getId(),
                blogEntity.getContent(), blogEntity.getPubDate(), blogEntity.getId());*/
    	
    	blogService.updateByPrimaryKey(blogEntity);
        return "redirect:/admin/blogs";
    }
    
 // 删除博客文章
    @RequestMapping("/admin/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        blogService.deleteByPrimaryKey(id);
        return "redirect:/admin/blogs";
    }
    
   /* @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	*/
	


	
}
