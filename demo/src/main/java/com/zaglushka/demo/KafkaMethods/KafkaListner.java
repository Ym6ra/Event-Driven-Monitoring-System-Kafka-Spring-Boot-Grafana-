package com.zaglushka.demo.KafkaMethods;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaglushka.demo.Entity.OrderEntity;
import com.zaglushka.demo.REST_Pattern.POST_pattern;
import com.zaglushka.demo.Repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
@Component
@Slf4j

public class KafkaListner {
    @KafkaListener(topics = "Order", groupId = "group_id")
    public void listen(POST_pattern message) {
        // System.out.println("Received message: " + message);
        log.info("Received message: {}", message);

        OrderEntity order = new OrderEntity();
            order.setCustomerId(message.getCustomerId());
            order.setProduct(message.getProduct());
            order.setQuantity(message.getQuantity());
        orderRepository.save(order);

    }
    @Autowired
    private OrderRepository orderRepository;
}
