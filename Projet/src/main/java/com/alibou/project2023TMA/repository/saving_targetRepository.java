package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.saving_target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface saving_targetRepository extends JpaRepository<saving_target, BigInteger> {
    @Query(value = "SELECT * FROM saving_target WHERE status <> 'inactive'", nativeQuery = true)
    List<saving_target> findSavingTargetNotDeleted();
}
