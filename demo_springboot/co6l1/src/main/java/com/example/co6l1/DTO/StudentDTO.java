package com.example.co6l1.DTO;

import com.example.co6l1.model.SchoolClass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentDTO {
    private Integer id;
    @NotBlank(message = "Vui lòng không được để trống")
    @Size(min =2,message = "Tên không được dưới 2 k tự")
    @Size(max = 30,message = "Tên không được vượt quá 30 ký tự")
    private String name;
    private Boolean gender;
    private Integer age;
    private SchoolClass className;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, Boolean gender, Integer age, SchoolClass className) {
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
