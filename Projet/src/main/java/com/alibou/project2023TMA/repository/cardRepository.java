package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface cardRepository extends JpaRepository<card, BigInteger> {

    @Query(value = "SELECT * FROM card WHERE status <> 'inactive'", nativeQuery = true)
    List<card> findCardNotDeleted();
}
