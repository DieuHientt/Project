package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.card_brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface card_brandRepository extends JpaRepository<card_brand, BigInteger> {
    @Query(value = "SELECT * FROM card_brand WHERE status <> 'inactive'", nativeQuery = true)
    List<card_brand> findCardBrandActive();
    @Query(value = "SELECT * FROM card_brand WHERE status <> 'inactive'", nativeQuery = true)
    List<card_brand> findCardBrandNotDeleted();

}
