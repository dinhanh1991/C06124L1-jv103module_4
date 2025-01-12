package com.example.co6l1.repository;

import com.example.co6l1.model.SchoolClass;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchoolClassRepo extends JpaRepository<SchoolClass, Integer> {
}
