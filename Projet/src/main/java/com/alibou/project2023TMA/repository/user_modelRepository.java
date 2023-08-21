package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.user_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface user_modelRepository extends JpaRepository<user_model, BigInteger> {
    @Query(value = "SELECT * FROM user_model WHERE status <> 'inactive'", nativeQuery = true)
    List<user_model> findUserModelNotDeleted();
}
