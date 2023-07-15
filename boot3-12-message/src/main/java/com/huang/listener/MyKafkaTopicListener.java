package com.huang.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @Author HYL
 * @Date 2023/7/14
 * @Version 1.0
 * @Description
 */
@Component
public class MyKafkaTopicListener {

    // 默认监听是从消息队列最后一个消息开始拿。新消息才能拿到
    @KafkaListener(topics = "newshaha", groupId = "haha")
    public void haha(ConsumerRecord record) {
        //1、获取消息的各种详细信息
        String topic = record.topic();
        Object key = record.key();
        Object value = record.value();
        System.out.println(topic + "收到消息。。。key：" + key + "，value：" + value);
    }


    // 拿完整消息
    @KafkaListener(groupId = "hehe", topicPartitions = {
            @TopicPartition(topic = "newshaha", partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0")
            })
    })
    public void hehe(ConsumerRecord record) {
        //1、获取消息的各种详细信息
        String topic = record.topic();
        Object key = record.key();
        Object value = record.value();
        System.out.println(topic + "收到消息。。。key：" + key + "，value：" + value);
    }

}
