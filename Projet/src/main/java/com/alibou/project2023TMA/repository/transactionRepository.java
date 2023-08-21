package com.alibou.project2023TMA.repository;


import com.alibou.project2023TMA.entity.transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface transactionRepository extends JpaRepository<transactions, BigInteger> {
    @Query(value = "SELECT * FROM transactions WHERE status <> 'inactive'", nativeQuery = true)
    List<transactions> findTransactionNotDeleted();
}
