package com.test.demo.netty;

import org.apache.commons.codec.digest.DigestUtils;

import net.sf.json.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String message)
			throws Exception {
		System.out.println("from client:" + message);
		JSONObject json = JSONObject.fromObject(message);
		String source = json.getString("source");

		String md5 = DigestUtils.md5Hex(source);
		// 解析成JSON
		json.put("md5Hex", md5);

		ctx.writeAndFlush(json.toString());// write bytes to socket,and
											// flush(clear) the buffer cache.

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

}
