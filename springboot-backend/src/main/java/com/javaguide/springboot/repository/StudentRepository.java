package com.javaguide.springboot.repository;

import com.javaguide.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student,Long> {
             // all crud database methods

}
