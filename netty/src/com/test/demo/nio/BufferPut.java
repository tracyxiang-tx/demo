package com.test.demo.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferPut {
	
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		print(buffer);
		byte H=0x48;
        byte e=0x65;
        byte l=0x6C;
        byte o=0x6F;
        buffer.put(H).put(e).put(l).put(l).put(o);
        print(buffer);
        //批量存储
        //buffer.put("Hello".getBytes());
        byte M=0x4D;
        byte w=0x77;
        //将"Hello"的 ASCII码改为"Mellow"
        buffer.put(0, M).put(w);
        
        //输出缓冲区
        buffer.flip();//buffer.limit(buffer.position()).position(0);
        int count = buffer.remaining();
        byte[] content = new byte[count];//构造一个与剩余可读元素大小相同的数组
        buffer.get(content);
        System.out.println(new String(content));
        print(buffer);
        
        //复制缓冲区
        CharBuffer charBuffer = CharBuffer.allocate (8);
        charBuffer.position(3).limit(6).mark().position(5);
        CharBuffer dupeBuffer = charBuffer.duplicate();
        print(dupeBuffer);
        
	}
	
	
	
	private static void print(Buffer... buffers) {
			
		for (Buffer buffer : buffers) {
			System.out.println("capacity=" + buffer.capacity()
					+ ",limit=" + buffer.limit()
					+ ",position=" + buffer.position()
					+ ",hasRemaining:" + buffer.hasRemaining()
					+ ",remaining=" + buffer.remaining()
					+ ",hasArray=" + buffer.hasArray()
					+ ",isReadOnly=" + buffer.isReadOnly()
					+ ",arrayOffset=" + buffer.arrayOffset());
			
		}
	}
}
