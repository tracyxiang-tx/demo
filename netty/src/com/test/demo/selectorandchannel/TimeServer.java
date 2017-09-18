package com.test.demo.selectorandchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
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
		ssc.socket().bind(new InetSocketAddress(8088));
		ssc.configureBlocking(false);
		
		Selector selector = Selector.open();
		ssc.register(selector, ssc.validOps());
		
		while (true) {
			int readyCount = selector.select(1000);
			if(readyCount == 0) {
				continue;
			}
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) keyIterator.next();
				if(selectionKey.isValid()) {
					//表示ServerSocketChannel
					if(selectionKey.isAcceptable()){
						ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
						SocketChannel socketChannel = server.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
						
						//say hello
						ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
						buffer.clear();
						buffer.put("Hi there!\r\n".getBytes());
						buffer.flip();
						socketChannel.write(buffer);
						
					}
					
					//表示SocketChannel
					if(selectionKey.isReadable()) {
						executor.submit(new TimeServerTask(selectionKey));
					}
					keyIterator.remove();
				}
				
			}
			
			
		}
		
	}
}
