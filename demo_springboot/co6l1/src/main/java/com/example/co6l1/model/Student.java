package com.example.co6l1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean gender;
    private Integer age;
    @ManyToOne
    @JoinColumn(name ="className")
    private SchoolClass className;

    public Student() {
    }

    public Student(Integer id, String name, Boolean gender, Integer age, SchoolClass className) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SchoolClass getClassName() {
        return className;
    }

    public void setClassName(SchoolClass className) {
        this.className = className;
    }
}
