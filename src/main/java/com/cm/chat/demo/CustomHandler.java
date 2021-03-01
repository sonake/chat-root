package com.cm.chat.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 自定义助手类, SimpleChannelInboundHandler对于请求来说，相当于入站
 * @Author xzyuan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/3/1
 */
@Slf4j
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {
    protected CustomHandler() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    protected void ensureNotSharable() {
        super.ensureNotSharable();
    }

    @Override
    public boolean isSharable() {
        return super.isSharable();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("助手类添加");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("助手类移除");
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel注册");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.info("channel移除");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel活跃");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel不活跃");
        super.channelInactive(ctx);
    }

    protected CustomHandler(boolean autoRelease) {
        super(autoRelease);
    }

    protected CustomHandler(Class<? extends HttpObject> inboundMessageType) {
        super(inboundMessageType);
    }

    protected CustomHandler(Class<? extends HttpObject> inboundMessageType, boolean autoRelease) {
        super(inboundMessageType, autoRelease);
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        return super.acceptInboundMessage(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("channel读取数据完成");
        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("用户事件触发");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        log.info("channel可写事件被更改");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("发生异常");
        // 关闭channel
        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        // 获取channel
        Channel channel = channelHandlerContext.channel();
        if(httpObject instanceof HttpRequest) {
            log.info(channel.remoteAddress() + "");
            ByteBuf content = Unpooled.copiedBuffer("hello netty!", CharsetUtil.UTF_8);
            //构建响应
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers()
                    .set(HttpHeaderNames.CONTENT_TYPE, "text/plain")
                    .set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 将数据刷到客户端
            channelHandlerContext.writeAndFlush(response);
        }
    }
}
