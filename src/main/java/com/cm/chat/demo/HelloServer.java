package com.cm.chat.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description ；实现客户端发送一个请求，服务器返回hello netty
 * @Author xzyuan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/3/1
 */
public class HelloServer {

    public static void main(String[] args) throws InterruptedException {
        // 定义一对线程组,
        // 主线程组,只处理客户端连接请求，不做其他任何处理
        EventLoopGroup masterGroup = new NioEventLoopGroup();
        // 从线程组，主线程组将任务分配给从线程组处理
        EventLoopGroup slaveGroup = new NioEventLoopGroup();
        try {
            // netty启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(masterGroup,slaveGroup) //设置主从线程组
                    .channel(NioServerSocketChannel.class)  //设置nio的双向通道
                    .childHandler(new HelloServerInitializer());   // 子处理器，用于处理从线程组

            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            masterGroup.shutdownGracefully();
            slaveGroup.shutdownGracefully();
        }



    }
}
