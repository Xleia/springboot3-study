package com.huang.health;

import com.huang.component.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 * 1、实现HealthIndicator 接口定制组件的健康对象返回
 * 2、继承AbstractHealthIndicator
 */
@Component
public class MyComponentHealthIndicator extends AbstractHealthIndicator {

    @Autowired
    MyComponent myComponent;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        int check = myComponent.check();
        if (check == 1) {
            // 存活
            builder.up().build();
        } else {
            // 下线
            builder.down().build();
        }
    }
}
