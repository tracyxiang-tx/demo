package com.test.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(8088);
			System.out.println("TimeServer Started on 8088...");
			while (true) {
				Socket client = server.accept();
				//每次接收到一个新的客户端连接，启动一个新的线程来处理
				new Thread(new TimeServerHandler(client)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
