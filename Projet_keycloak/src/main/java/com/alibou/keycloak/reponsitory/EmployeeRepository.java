package com.alibou.keycloak.reponsitory;


import com.alibou.keycloak.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}