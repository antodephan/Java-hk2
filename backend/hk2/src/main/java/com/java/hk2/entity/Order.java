package com.java.hk2.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "store_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeId; // ID của cửa hàng (VD: CH-Q1)
    private LocalDateTime orderDate;
    private String status; // PENDING, PROCESSING, SHIPPING, COMPLETED
    private String note;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items; // Danh sách sản phẩm trong đơn (Phở, Bún,...)
}
