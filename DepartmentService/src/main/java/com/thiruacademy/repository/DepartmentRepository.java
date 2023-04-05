package com.thiruacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiruacademy.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
