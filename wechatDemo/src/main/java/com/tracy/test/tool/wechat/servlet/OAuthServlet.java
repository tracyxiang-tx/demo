package com.tracy.test.tool.wechat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracy.test.tool.wechat.pojo.SNSUserInfo;
import com.tracy.test.tool.wechat.pojo.WeixinOauth2Token;
import com.tracy.test.tool.wechat.util.AdvancedUtil;
import com.tracy.test.tool.wechat.util.GetAuthorityfromProperties;

/**
* 类名: OAuthServlet </br>
* 描述: 授权后的回调请求处理 </br>
* 开发人员： souvc </br>
* 创建时间：  2015-11-27 </br>
* 发布版本：V1.0  </br>
 */
public class OAuthServlet extends HttpServlet {
    private static final long serialVersionUID = -1847238807216447030L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        
        // 用户同意授权
        if (!"authdeny".equals(code)) {
        	GetAuthorityfromProperties ga = new GetAuthorityfromProperties();
        	String auth[] = ga.getAuthority().split(",");
        	
            // 第三方用户唯一凭证
            String appId = auth[0];
            // 第三方用户唯一凭证密钥
            String appSecret = auth[1];
            
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(appId, appSecret, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            request.setAttribute("snsUserInfo", snsUserInfo);
            request.setAttribute("state", state);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}