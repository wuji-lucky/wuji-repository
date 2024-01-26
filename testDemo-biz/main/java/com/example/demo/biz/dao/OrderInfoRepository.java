package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, String> {
  OrderInfoEntity findByOrderId(String orderId);
}
