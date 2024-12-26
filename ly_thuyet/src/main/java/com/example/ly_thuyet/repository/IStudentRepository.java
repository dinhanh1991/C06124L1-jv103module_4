package com.example.ly_thuyet.repository;

import com.example.ly_thuyet.model.Student;

import java.util.List;

public interface IStudentRepository {
    public List<Student> findAll();
    void save(Student student);
}
