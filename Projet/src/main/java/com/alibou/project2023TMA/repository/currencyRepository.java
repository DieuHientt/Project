package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface currencyRepository extends JpaRepository<currency, BigInteger> {
    @Query(value = "SELECT * FROM currency WHERE status <> 'inactive'", nativeQuery = true)
    List<currency> findCurrencyNotDeleted();
}
