// OrderService

package com.att.tdp.bisbis10.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String placeOrder(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }
}

