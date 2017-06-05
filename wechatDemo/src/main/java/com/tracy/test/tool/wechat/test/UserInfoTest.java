package com.tracy.test.tool.wechat.test;

import java.sql.SQLException;

import org.junit.Test;

import com.tracy.test.tool.wechat.pojo.WeixinUserInfo;
import com.tracy.test.tool.wechat.util.CommonUtil;
import com.tracy.test.tool.wechat.util.DBUtility;
import com.tracy.test.tool.wechat.util.GetAuthorityfromProperties;

public class UserInfoTest {

	@Test
	public void testgetUserInfo() throws SQLException {
		GetAuthorityfromProperties ga = new GetAuthorityfromProperties();
		String auth[] = ga.getAuthority().split(",");

		// 第三方用户唯一凭证
		String appId = auth[0];
		// 第三方用户唯一凭证密钥
		String appSecret = auth[1];

		// 获取接口访问凭证
		String accessToken = CommonUtil.getToken(appId,
				appSecret).getAccessToken();
		/**
		 * 获取用户信息
		 */
		String userOpenIdString = "XXXXXXXXXX";
		WeixinUserInfo user = CommonUtil.getUserInfo(accessToken,
				userOpenIdString);
		System.out.println("OpenID：" + user.getOpenId());
		System.out.println("关注状态：" + user.getSubscribe());
		System.out.println("关注时间：" + user.getSubscribeTime());
		System.out.println("昵称：" + user.getNickname());
		System.out.println("性别：" + user.getSex());
		System.out.println("国家：" + user.getCountry());
		System.out.println("省份：" + user.getProvince());
		System.out.println("城市：" + user.getCity());
		System.out.println("语言：" + user.getLanguage());
		System.out.println("头像：" + user.getHeadImgUrl());
	}

}
