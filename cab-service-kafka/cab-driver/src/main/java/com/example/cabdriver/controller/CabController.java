package com.example.cabdriver.controller;

import com.example.cabdriver.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cab")
public class CabController {

    private final LocationService locationService;

    public CabController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PutMapping("/updateLocation")
    public ResponseEntity<Map<String, String>> updateLocation() {

        int count = 100;
        boolean serviceStatus = true;
        while(count > 0 && serviceStatus) {
            serviceStatus = locationService.updateLocation(Math.random() + ", " + Math.random());
            count --;
        }

        return new ResponseEntity<>(Map.of("message", "message body"), HttpStatus.OK);
    }
}
