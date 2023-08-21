package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface outcomeRepository extends JpaRepository<outcome, BigInteger> {
    @Query(value = "SELECT * FROM outcome WHERE status <> 'inactive'", nativeQuery = true)
    List<outcome> findOutcomeNotDeleted();
}
