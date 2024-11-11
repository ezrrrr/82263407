package com.example.demo.repository;

import com.example.demo.domain.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	
    @Query(value = "SELECT t FROM UserInfo t WHERE t.id = :id ")
    List<UserInfo> getUserItemById(@Param("id") Long id);	
	
}
