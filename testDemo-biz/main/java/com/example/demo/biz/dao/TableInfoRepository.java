package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.TableInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableInfoRepository extends JpaRepository<TableInfoEntity, String> {
  TableInfoEntity findByTableId(String tableId);
}
