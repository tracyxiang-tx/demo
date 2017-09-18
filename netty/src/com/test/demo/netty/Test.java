package com.test.demo.netty;

import org.apache.commons.lang.RandomStringUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		NettyServer nettyServer = new NettyServer();
		nettyServer.start();// 启动server
		Thread.sleep(3000);

		NettyClient nettyClient = new NettyClient();
		nettyClient.start();

		try {
			for (int i = 0; i < 5; i++) {
				String response = nettyClient.send(RandomStringUtils.random(32,
						true, true));
				System.out.println("response:" + response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			nettyClient.close();
		}

		nettyServer.close();
	}
}
