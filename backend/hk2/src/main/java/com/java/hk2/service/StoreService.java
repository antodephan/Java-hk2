package com.java.hk2.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.hk2.repository.OrderRepository;

@Service
public class StoreService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING"); // Mặc định đơn mới là chờ xử lý
        return orderRepository.save(order);
    }

    public List<Order> getHistory(String storeId) {
        return orderRepository.findByStoreId(storeId);
    }

    public Order confirmReceived(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("COMPLETED");
        return orderRepository.save(order);
    }
}
}
