package com.java.hk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Tìm các đơn hàng theo ID cửa hàng để hiển thị cho nhân viên
    List<Order> findByStoreId(String storeId);
}
