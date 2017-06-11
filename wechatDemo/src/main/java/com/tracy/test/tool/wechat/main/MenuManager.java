package com.tracy.test.tool.wechat.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tracy.test.tool.wechat.menu.Button;
import com.tracy.test.tool.wechat.menu.CommonButton;
import com.tracy.test.tool.wechat.menu.ComplexButton;
import com.tracy.test.tool.wechat.menu.Menu;
import com.tracy.test.tool.wechat.pojo.AccessToken;
import com.tracy.test.tool.wechat.util.GetAuthorityfromProperties;
import com.tracy.test.tool.wechat.util.WeixinUtil;

/**
* 类名: MenuManager </br>
* 包名： com.tracy.test.tool.wechat.main
* 描述:菜单管理器类 </br>
* 开发人员： liuhf </br>
* 创建时间：  2015-12-1 </br>
* 发布版本：V1.0  </br>
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
    	
    	GetAuthorityfromProperties ga = new GetAuthorityfromProperties();
    	String auth[] = ga.getAuthority().split(",");
    	
        // 第三方用户唯一凭证
        String appId = auth[0];
        // 第三方用户唯一凭证密钥
        String appSecret = auth[1];

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("打开链接");
        btn11.setType("view");
        btn11.setUrl("http://www.runoob.com");

        CommonButton btn12 = new CommonButton();
        btn12.setName("点击回复");
        btn12.setType("click");
        btn12.setKey("12");
        
        CommonButton btn13 = new CommonButton();
        btn13.setName("扫码");
        btn13.setType("scancode_push");
        btn13.setKey("13");
        
        CommonButton btn14 = new CommonButton();
        btn14.setName("扫码回信息");
        btn14.setType("scancode_waitmsg");
        btn14.setKey("14");
        
        CommonButton btn15 = new CommonButton();
        btn15.setName("发送位置");
        btn15.setType("location_select");
        btn15.setKey("15");
        

        CommonButton btn21 = new CommonButton();
        btn21.setName("系统拍照发图");
        btn21.setType("pic_photo_or_album");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("微信相册发图");
        btn22.setType("pic_weixin");
        btn22.setKey("22");
        
        CommonButton btn23 = new CommonButton();
        btn23.setName("拍照相册发图");
        btn23.setType("pic_sysphoto");
        btn23.setKey("23");

        
        //需要在微信公众平台配置素材获得素材的media_id
       /* CommonButton btn24 = new CommonButton();
        btn24.setName("发消息除文本");
        btn24.setType("media_id");
        btn24.setMediaId("24");
        
        CommonButton btn25 = new CommonButton();
        btn25.setName("图文消息");
        btn25.setType("view_limited");
        btn25.setMediaId("25");*/
        
        CommonButton btn31 = new CommonButton();
        btn31.setName("vae+");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("许嵩官方论坛");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("许嵩百度图片");
        btn33.setType("click");
        btn33.setKey("33");

        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("测试1");
        //一级下有4个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14, btn15 });

        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("发图功能");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23 });

        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("许嵩相关");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}
