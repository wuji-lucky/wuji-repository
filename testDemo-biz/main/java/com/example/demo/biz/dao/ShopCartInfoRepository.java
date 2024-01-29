package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.ShopCartInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopCartInfoRepository extends JpaRepository<ShopCartInfoEntity, String> {

  /** 通过主键查询购物车数据 */
  ShopCartInfoEntity findByShopCartId(String shopCartId);

  /** 通过桌号查询当前餐桌的购物车菜品所有数据 */
  List<ShopCartInfoEntity> findByTableId(String tableId);

  /** 通过桌号查询当前餐桌的购物车菜品数量 */
  @Query(
      value = "SELECT SUM(goods_num) FROM shop_cart_info_entity WHERE table_id = :tableId",
      nativeQuery = true)
  Integer getTotalNumByTableId(String tableId);
}
