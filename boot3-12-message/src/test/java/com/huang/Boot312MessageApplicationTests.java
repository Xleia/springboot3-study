package com.huang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class Boot312MessageApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    void contextLoads() {

        StopWatch stopWatch = new StopWatch();

        CompletableFuture[] futures = new CompletableFuture[10000];

        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            CompletableFuture future = kafkaTemplate.send("newshaha", "haha", "哈哈哈");
            futures[i] = future;
        }
        CompletableFuture.allOf(futures)
                .join();
        stopWatch.stop();

        long millis = stopWatch.getTotalTimeMillis();
        System.out.println("10000消息发送时间：" + millis + "ms");
    }

}
