package com.example.co6l1.service.school_class;

import com.example.co6l1.model.SchoolClass;
import com.example.co6l1.repository.ISchoolClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService implements ISchoolClassService{
    @Autowired
    private ISchoolClassRepo schoolClassRepo;

    @Override
    public List<SchoolClass> getAllSchoolClass() {
        return schoolClassRepo.findAll();
    }

    @Override
    public SchoolClass getSchoolClassById(Integer id) {
        return schoolClassRepo.findById(id).orElse(null);
    }

    @Override
    public void saveSchoolClass(SchoolClass schoolClass) {
        schoolClassRepo.save(schoolClass);
    }

    @Override
    public void deleteSchoolClass(Integer id) {
        schoolClassRepo.deleteById(id);
    }
}
