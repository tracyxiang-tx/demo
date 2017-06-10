package com.tracy.test.controller;

import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tracy.test.entity.User;
import com.tracy.test.service.UserServiceI;





@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger("UserController.class"); 

	// 自动装配数据库接口，不需要再写原始的Connection来操作数据库
	@Autowired
	private UserServiceI userService;

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String getUsers(ModelMap modelMap) {
		// 查询user表中所有记录
		// 获取所有的用户信息
		List<User> userList = userService.getAllUser();
		logger.warn("warn:查询数据库");
		// 将所有记录传递给要返回的jsp页面，放在userList当中
		modelMap.addAttribute("userList", userList);

		// 返回pages目录下的admin/users.jsp页面
		return "admin/users";
	}

	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String addUser() {
		// 转到 admin/addUser.jsp页面
		return "admin/addUser";
	}

	@RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
	public String addUserPost(@ModelAttribute("user") User user) {
		// 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
		// 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

		// 数据库中添加一个用户，该步暂时不会刷新缓存
		// userRepository.save(userEntity);
		userService.addUser(user);
		// 数据库中添加一个用户，并立即刷新缓存
		// userService.saveAndFlush(user);

		// 重定向到用户管理页面，方法为 redirect:url
		return "redirect:/admin/users";
	}

	// 删除用户
	@RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer userId) {

		// 删除id为userId的用户
		userService.deleteByPrimaryKey(userId);
		// 立即刷新
		// userService.flush();
		return "redirect:/admin/users";
	}

	// 查看用户
	@RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

		// 删除id为userId的用户
		User user = userService.selectByPrimaryKey(userId);
		// 传递给请求页面
	    modelMap.addAttribute("user", user);
	    return "admin/userDetail";
	}

	// 更新用户信息 页面
	@RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
	public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

	    // 找到userId所表示的用户
	    User user = userService.selectByPrimaryKey(userId);

	    // 传递给请求页面
	    modelMap.addAttribute("user", user);
	    return "admin/updateUser";
	}

	// 更新用户信息 操作
	@RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
	public String updateUserPost(@ModelAttribute("userP") User user) {

	    // 更新用户信息
		userService.updateByPrimaryKey(user);
	    //userRepository.flush(); // 刷新缓冲区
	    return "redirect:/admin/users";
	}


	
}
