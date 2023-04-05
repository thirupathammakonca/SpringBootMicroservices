package com.thiruacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiruacademy.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
