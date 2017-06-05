package com.tracy.test.tool.wechat.test;

import com.tracy.test.tool.wechat.util.CommonUtil;

public class TestURL {

    /**     
     * 方法名：main</br>
     * 详述：生成URL编码 </br>
     * 开发人员：souvc </br>
     * 创建时间：2016-1-4  </br>
     * @param args 说明返回值含义
     * @throws 说明发生此异常的条件
     */
    public static void main(String[] args) {
        String source="http://xyyvae.tunnel.2bdata.com/wechatDemo/oauthServlet";
        System.out.println(CommonUtil.urlEncodeUTF8(source));
    }

}
