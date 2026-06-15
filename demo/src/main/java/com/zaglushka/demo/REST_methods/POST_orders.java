package com.zaglushka.demo.REST_methods;

import java.io.IOException;
// import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.zaglushka.demo.REST_Pattern.POST_pattern;

@RestController
@RequestMapping

public class POST_orders {
    @RequestMapping(value = "/api/order", method = RequestMethod.POST)
    public ResponseEntity<String> createOrder(@RequestBody POST_pattern request) throws IOException {
        try {
            if (request.getCustomerId() != null && request.getProduct() != null && request.getQuantity() != null) {
                if (request.getCustomerId() != 0 && !request.getProduct().isEmpty() && request.getQuantity() != 0) {
                    if(request.getCustomerId() == 123 && request.getProduct().equals("Phone") && request.getQuantity() == 1) {
                        return ResponseEntity.ok("Заказ успешно создан");
                    } else {
                        return ResponseEntity.ok("Заказ успешно создан, но данные не совпадают с ожидаемыми");
                    }
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Некорректные данные заказа");
            }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Некорректные данные заказа");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(String.format("Ошибка при создании заказа %s", e.getMessage()));
        }
    }
}