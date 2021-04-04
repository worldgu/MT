package com.zero.herostory;/**
 * Created by 张春海 on 2021/4/4  20:27
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

/**
 *@ClassName GameMsgHandler
 *@Description TODO
 *@Author 张春海
 *@Date 2021/4/4 20:27 
 *@Version 1.0 */
public class GameMsgHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到客户端消息， msg = " + msg);

        // WebSocket 二进制消息会通过HttpServerCode 解码成 BinaryWebSocketFrame 类
        BinaryWebSocketFrame frame = (BinaryWebSocketFrame) msg;
        ByteBuf byteBuf = frame.content();

        // 拿到真的字符数组并打印
        byte[] byteArray = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(byteArray);

        System.out.println("收到的字节 ==");

        for (byte b : byteArray) {
            System.out.println(b);
            System.out.println(", ");
        }

        System.out.println();
    }
}
