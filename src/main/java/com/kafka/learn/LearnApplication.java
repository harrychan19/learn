package com.kafka.learn;

import com.kafka.learn.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

    @Autowired
    KafkaProducer kafkaProducer;

    @RequestMapping("/testSendMsg")
    public void testSendMsg(){
        kafkaProducer.send();
    }
}
