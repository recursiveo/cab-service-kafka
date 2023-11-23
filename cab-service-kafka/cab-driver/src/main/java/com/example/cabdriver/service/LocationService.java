package com.example.cabdriver.service;

import com.example.cabdriver.constant.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public LocationService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean updateLocation(String location) {

        try{
            kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
            Thread.sleep(1000);
            return true;
        }catch (InterruptedException e) {
           logger.error(e.getMessage());
           Thread.currentThread().interrupt();
           return false;
        }
    }
}
