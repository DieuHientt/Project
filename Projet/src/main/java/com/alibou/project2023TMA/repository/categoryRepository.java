package com.alibou.project2023TMA.repository;


import com.alibou.project2023TMA.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface categoryRepository extends JpaRepository<category, BigInteger> {
    @Query(value = "SELECT * FROM category WHERE status <> 'inactive'", nativeQuery = true)
    List<category> findCategoryNotDeleted();
}
