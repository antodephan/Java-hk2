package com.java.hk2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.hk2.service.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    // API Tạo đơn hàng mới
    @PostMapping("/orders")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok(storeService.createOrder(order));
    }

    // API Lấy danh sách đơn hàng của cửa hàng
    @GetMapping("/orders/{storeId}")
    public List<Order> getOrders(@PathVariable String storeId) {
        return storeService.getHistory(storeId);
    }

    // API Xác nhận đã nhận hàng
    @PutMapping("/orders/{id}/confirm")
    public ResponseEntity<Order> confirm(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.confirmReceived(id));
    }
}
