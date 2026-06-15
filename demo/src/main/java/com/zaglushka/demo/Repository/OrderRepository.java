package com.zaglushka.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaglushka.demo.Entity.OrderEntity;

public interface OrderRepository
        extends JpaRepository<OrderEntity, Integer> {

}
