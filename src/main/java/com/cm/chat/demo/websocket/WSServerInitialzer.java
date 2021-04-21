package com.cm.chat.demo.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ClassName WSServerInitialzer
 * @Description <p>TODO<p>
 * @Author DK
 * @Date 2021/4/19 10:29
 * @Version 1.0
 **/
public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // =================http相关支持================
        pipeline.addLast(new HttpServerCodec());
        //大数据流支持
        pipeline.addLast(new ChunkedWriteHandler());
        // httpmessage进行聚合，聚合成fullhttprequest或fullhttpresponse，netty编程遍布使用
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        // =================websocket=============

        /** @Author DK
          * @Description websocket 服务器处理的协议，用于指定给客户端连接访问的路由： /ws
         * 该handler会处理一些繁重复杂的工作，handshaking（close，ping，pong，心跳）
         * 数据已frames传输，不同数据类型对应的frames不同
          * @Date 10:39 2021/4/19
          * @Param [io.netty.channel.socket.SocketChannel]
          * @return void
         **/
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        // 添加自定义handler
        pipeline.addLast(new ChatHandler());
    }
}
