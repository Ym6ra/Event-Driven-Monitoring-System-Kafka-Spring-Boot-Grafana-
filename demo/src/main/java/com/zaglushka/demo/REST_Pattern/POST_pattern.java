package com.zaglushka.demo.REST_Pattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class POST_pattern {
    private Integer customerId;
    private String product;
    private Integer quantity;
}
