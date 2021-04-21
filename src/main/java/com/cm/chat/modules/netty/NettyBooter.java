package com.cm.chat.modules.netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName NettyBooter
 * @Description <p>TODO<p>
 * @Author DK
 * @Date 2021/4/21 12:00
 * @Version 1.0
 **/
@Component
@Slf4j
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent()==null){
            try {
                CmWsServer.getInstance().start();
                log.info("netty启动成功");
            }catch (Exception e){
                log.error("netty服务启动失败!!!");
            }
        }
    }
}
