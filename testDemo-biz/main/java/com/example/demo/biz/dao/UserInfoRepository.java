package com.example.demo.biz.dao;

import com.example.demo.biz.dao.entity.UserInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {
  UserInfoEntity findByUuid(String uuid);

  Page<UserInfoEntity> findByUserName(String userName, Pageable pageable);
}
