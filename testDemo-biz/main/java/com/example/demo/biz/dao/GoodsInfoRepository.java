package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.GoodsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsInfoRepository extends JpaRepository<GoodsInfoEntity, String> {

  /** 通过主键查询相应的菜品 */
  GoodsInfoEntity findByGoodsId(String goodsId);

  List<GoodsInfoEntity> findAll();
}
