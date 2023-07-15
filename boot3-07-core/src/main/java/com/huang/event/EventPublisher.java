package com.huang.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */
@Service
public class EventPublisher implements ApplicationEventPublisherAware {

    /**
     * 底层发送事件的组件，SpringBoot会通过ApplicationEventPublisherAware接口自动注入
     * 事件是通过广播出去的，所有监听这个事件的监听器都能收到
     */
    ApplicationEventPublisher applicationEventPublisher;

    /**
     * 所有事件都可以发（自定义的）
     *
     * @param event
     */
    public void sendEvent(ApplicationEvent event) {
        // 事件广播
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        // 调用底层API发送事件
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
