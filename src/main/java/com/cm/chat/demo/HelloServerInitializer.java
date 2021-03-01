package com.cm.chat.demo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Description 初始化器，channel注册后，会执行里面的相应的初始化方法
 * @Author xzyuan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/3/1
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //通过socketChannel获取管道
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        // netty自己提供的助手类，当请求到服务端时，需要做编解码，相应到客户端做编码
        channelPipeline.addLast("HttpServerCodec",new HttpServerCodec());
        // 自定义助手类，返回hello netty
        channelPipeline.addLast("customHandle",new CustomHandler());
    }
}
