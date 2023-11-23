package com.example.cabuser.service;

import com.example.cabuser.constant.AppConstant;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = AppConstant.CAB_LOCATION, groupId = "user-group")
    public void listen(String location) {
        System.out.println(location);
    }
}
