package com.example.ly_thuyet.repository;

import com.example.ly_thuyet.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<Student>();
    static {
        students.add(new Student(1,"Hạnh",true));
        students.add(new Student(2,"Tình",false));
        students.add(new Student(3,"Huy",true));
        students.add(new Student(4,"Trang",false));
    }
    @Override
    public List<Student> findAll() {
        return students;
    }
    @Override
    public void save(Student student) {
        students.add(student);
    }
}
