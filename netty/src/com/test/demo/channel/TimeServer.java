package com.test.demo.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServer {

	private static ExecutorService executor;
	
	static {
		executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));
		
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress(8088));
		
		while (true) {
			SocketChannel socketChannel = ssc.accept();
			if(socketChannel == null){
				continue;
			}else{
				socketChannel.configureBlocking(false);
				executor.execute(new TimeServerHandleTask(socketChannel,executor));
			}
		}
		
	}
}
