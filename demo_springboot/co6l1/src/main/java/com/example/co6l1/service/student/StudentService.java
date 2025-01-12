package com.example.co6l1.service.student;

import com.example.co6l1.model.Student;
import com.example.co6l1.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepo studentRepo;

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {

        return studentRepo.findAll(pageable);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepo.deleteById(id);
    }
}
