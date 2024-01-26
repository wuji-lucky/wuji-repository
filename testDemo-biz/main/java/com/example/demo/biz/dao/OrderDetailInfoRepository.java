package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.OrderDetailInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailInfoRepository extends JpaRepository<OrderDetailInfoEntity, String> {
  OrderDetailInfoEntity findByOrderDetailId(String orderDetailId);
}
