package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.GoodsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsInfoRepository extends JpaRepository<GoodsInfoEntity, String> {
  GoodsInfoEntity findByGoodsId(String goodsId);
}
