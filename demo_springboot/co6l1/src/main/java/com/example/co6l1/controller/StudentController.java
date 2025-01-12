package com.example.co6l1.controller;

import com.example.co6l1.DTO.StudentDTO;
import com.example.co6l1.model.Student;
import com.example.co6l1.service.school_class.SchoolClassService;
import com.example.co6l1.service.student.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SchoolClassService schoolClassService;

    @GetMapping("")
    public ModelAndView showHomePage(Model model, @RequestParam(name = "page",defaultValue = "0",required = false) int page) {
        ModelAndView mav = new ModelAndView("students");
        Pageable pageable =  PageRequest.of(page, 2);
        mav.addObject("students",studentService.getAllStudents(pageable));
        mav.addObject("currentPage", page);
        mav.addObject("totalPages", studentService.getAllStudents(pageable).getTotalPages());
        return mav;
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "student";
    }
    @GetMapping ("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
    model.addAttribute("student", studentService.getStudentById(id));
    return "/studentDelete";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        model.addAttribute("schoolClasses",schoolClassService.getAllSchoolClass());
        return "/studentCreate";
    }
    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id,Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("schoolClasses",schoolClassService.getAllSchoolClass());
        return "/studentUpdate";
    }
    @PostMapping("/save")
    public String save(@Valid@ModelAttribute("studentDTO") StudentDTO studentDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,Model model) {
        //studentService.addStudent(student);
        if (bindingResult.hasErrors()) {
            model.addAttribute("schoolClasses",schoolClassService.getAllSchoolClass());
            return "/studentCreate";
        }
        redirectAttributes.addFlashAttribute("message", "Student added successfully!");
        return "redirect:/";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/studentUpdate";
        }
        redirectAttributes.addFlashAttribute("message", "Student updated successfully!");
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteStudent(Integer id, RedirectAttributes redirectAttributes) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudentById(id);
            redirectAttributes.addFlashAttribute("message", "Student deleted successfully!");
        }
        return "redirect:/delete-success";
    }
    @GetMapping("/delete-success")
    public String deleteSuccess() {
        return "studentDeleteSuccess";
    }
}
