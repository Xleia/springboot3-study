package com.huang.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @Author HYL
 * @Date 2023/7/11
 * @Version 1.0
 * @Description SpringBoot应用生命周期监听
 */

@Slf4j
public class MyAppListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        log.info("==============starting============正在启动===============");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        log.info("==============environmentPrepared============环境准备完成===============");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("==============contextPrepared============ioc容器准备完成===============");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("==============contextLoaded============ioc容器加载完成===============");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("==============started============启动完成===============");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("==============ready============准备就绪===============");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("==============failed============应用启动失败===============");
    }
}
