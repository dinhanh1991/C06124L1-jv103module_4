package com.example.co6l1.service.school_class;

import com.example.co6l1.model.SchoolClass;

import java.util.List;

public interface ISchoolClassService {
    List<SchoolClass> getAllSchoolClass();
    SchoolClass getSchoolClassById(Integer id);
    void saveSchoolClass(SchoolClass schoolClass);
    void deleteSchoolClass(Integer id);
}
