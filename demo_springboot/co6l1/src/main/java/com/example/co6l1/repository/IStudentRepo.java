package com.example.co6l1.repository;

import com.example.co6l1.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
}
