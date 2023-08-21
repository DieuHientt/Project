package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
import java.util.List;

@Repository
public interface walletRepository extends JpaRepository<wallet, BigInteger> {
    @Query(value = "SELECT * FROM wallet WHERE status <> 'inactive'", nativeQuery = true)
    List<wallet> findWalletNotDeleted();
}
