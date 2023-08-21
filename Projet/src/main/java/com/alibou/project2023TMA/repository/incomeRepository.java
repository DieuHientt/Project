package com.alibou.project2023TMA.repository;


import com.alibou.project2023TMA.entity.income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface incomeRepository extends JpaRepository<income, BigInteger> {
    @Query(value = "SELECT * FROM income WHERE status <> 'inactive'", nativeQuery = true)
    List<income> findIncomeNotDeleted();
}
