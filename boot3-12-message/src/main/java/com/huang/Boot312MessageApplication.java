package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * KafkaAutoConfiguration提供如下功能
 * 1、KafkaProperties：Kafka的所有配置
 *      - bootstrapServers ：kafka集群的所有服务器地址
 *      - properties：参数设置
 *      - producer：生产者
 *      - consumer：消费者
 * 2、开启kafka：@EnableKafka
 */

@SpringBootApplication
public class Boot312MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot312MessageApplication.class, args);
    }

}
