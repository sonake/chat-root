package com.cm.chat.demo.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName ChatHandler
 * @Description TextWebSocketFrame适用于专门为websocket处理文本的对象，frame是消息载体
 * @Author DK
 * @Date 2021/4/20 10:38
 * @Version 1.0
 **/
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // y用于记录和管理所有客户端的channel
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开短id："+ctx.channel().id().asShortText());
        System.out.println("客户端断开长id："+ctx.channel().id().asLongText());

    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String text = textWebSocketFrame.text();
        System.out.println("接收到客户端消息："+text);
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("服务端返回消息:"+ text));
        }

//      与上述代码类似  channels.writeAndFlush(new TextWebSocketFrame("接收到消息:"+ text));

    }
}
