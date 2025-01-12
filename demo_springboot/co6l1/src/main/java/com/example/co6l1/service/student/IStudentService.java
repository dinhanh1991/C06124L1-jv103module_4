package com.example.co6l1.service.student;

import com.example.co6l1.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> getAllStudents(Pageable pageable);
    Student getStudentById(Integer id);
    Student addStudent(Student student);
    void deleteStudentById(Integer id);
}
