package com.zaglushka.demo.KafkaMethods;

import  java.io.IOException;


import org.springframework.web.bind.annotation.RestController;

import com.zaglushka.demo.REST_Pattern.POST_pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.http.HttpStatus;
// import com.zaglushka.demo.KafkaConfig.KafkaProducerConfig;




@RestController
@RequestMapping

public class CreateOrder {
    @RequestMapping(value="api/create_order", method=RequestMethod.POST)
    public ResponseEntity<String> createOrder(
        @RequestBody POST_pattern request) throws IOException {
        try {
            if (request.getCustomerId() != null 
            && 
            request.getProduct() != null 
            && 
            request.getQuantity() != null) {
                if (request.getCustomerId() != 0 &&
                !request.getProduct().equals("") &&
                request.getQuantity() != 0) {
                    send(request);
                    return ResponseEntity.ok("Заказ успешно создан");
                }
            } else {
                return ResponseEntity.badRequest().body(
                    "Некорректные данные заказа"
                );
            }
            return ResponseEntity.badRequest().body(
                "Некорректные данные заказа"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(
                String.format("Ошибка при создании заказа %s",
                e.getMessage())
                );
        }
    }
    @Autowired
    private KafkaTemplate<String, POST_pattern> kt;

    public void send(POST_pattern  request) {
        kt.send("Order", request);
    } 
}


