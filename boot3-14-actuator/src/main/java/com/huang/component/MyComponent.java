package com.huang.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 */
@Component
public class MyComponent {
    private Counter counter = null;

    public MyComponent(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("myComponent.hello");
    }

    public int check() {
        // 实际中自己编写业务代码来判断此组件是否存活

        return 1;
    }

    public void hello() {
        System.out.println("hello");
        counter.increment();
    }
}
