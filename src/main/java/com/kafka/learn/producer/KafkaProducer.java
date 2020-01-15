package com.kafka.learn.producer;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Administrator
 */
@Component
public class KafkaProducer {
    private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    @SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        for(int i=0;i<5;i++){
            JSONObject message = new JSONObject();
            message.put("id", UUID.randomUUID());
            message.put("title", "第"+i+"个消息");
            logger.info("发送消息 ----->>>>>  message = {}", message.toJSONString());
            kafkaTemplate.send("hello", message.toJSONString());
        }
    }


}