package com.alibou.project2023TMA.repository;

import com.alibou.project2023TMA.entity.report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface reportRepository extends JpaRepository<report, BigInteger> {
    @Query(value = "SELECT * FROM report WHERE status <> 'inactive'", nativeQuery = true)
    List<report> findReportNotDeleted();
}
