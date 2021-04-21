package com.cm.chat.modules.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @ClassName WSServer
 * @Description <p>TODO<p>
 * @Author DK
 * @Date 2021/4/19 10:14
 * @Version 1.0
 **/
@Component
public class CmWsServer {


    private static class SingleWsServer{
        static final CmWsServer instance = new CmWsServer();

    }

    public static CmWsServer getInstance(){
        return SingleWsServer.instance;
    }

    public CmWsServer(){
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(mainGroup,subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitialzer());
    }

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ChannelFuture future;
    private ServerBootstrap serverBootstrap;


    public void start(){
        this.future = serverBootstrap.bind(8099);
        System.err.println("server启动完毕");
    }



}
