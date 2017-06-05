package com.tracy.test.tool.wechat.test;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.junit.Test;

import com.tracy.test.tool.wechat.pojo.Token;
import com.tracy.test.tool.wechat.util.CommonUtil;
import com.tracy.test.tool.wechat.util.GetAuthorityfromProperties;
import com.tracy.test.tool.wechat.util.MyX509TrustManager;
import com.tracy.test.tool.wechat.util.TokenUtil;

public class TokenTest {

    @Test
    public void testGetToken1() throws Exception {
    	GetAuthorityfromProperties ga = new GetAuthorityfromProperties();
    	String auth[] = ga.getAuthority().split(",");
    	
        // 第三方用户唯一凭证
        String appId = auth[0];
        // 第三方用户唯一凭证密钥
        String appSecret = auth[1];
        
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSecret;
        // 建立连接
        URL url = new URL(tokenUrl);
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        httpUrlConn.setSSLSocketFactory(ssf);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);

        // 设置请求方式（GET/POST）
        httpUrlConn.setRequestMethod("GET");

        // 取得输入流
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 读取响应内容
        StringBuffer buffer = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        // 释放资源
        inputStream.close();
        httpUrlConn.disconnect();
        // 输出返回结果
        System.out.println(buffer);
    }

    @Test
    public void testGetToken2() {
    	GetAuthorityfromProperties ga = new GetAuthorityfromProperties();
    	String auth[] = ga.getAuthority().split(",");
    	
        // 第三方用户唯一凭证
        String appId = auth[0];
        // 第三方用户唯一凭证密钥
        String appSecret = auth[1];
        System.out.println(appId + " "+appSecret);
        Token token = CommonUtil.getToken(appId,appSecret);
        System.out.println("access_token:"+token.getAccessToken());
        System.out.println("expires_in:"+token.getExpiresIn());
    }
    
    @Test
    public void testGetToken3() {
        Map<String, Object> token=TokenUtil.getToken();
        System.out.println(token.get("access_token"));
        System.out.println(token.get("expires_in"));
    }
    
    
    @Test
    public void testSaveToken4() {
    	GetAuthorityfromProperties ga = new GetAuthorityfromProperties();
    	String auth[] = ga.getAuthority().split(",");
    	
        // 第三方用户唯一凭证
        String appId = auth[0];
        // 第三方用户唯一凭证密钥
        String appSecret = auth[1];
        
        Token token=CommonUtil.getToken(appId, appSecret);
        TokenUtil.saveToken(token);
    }
   
}
