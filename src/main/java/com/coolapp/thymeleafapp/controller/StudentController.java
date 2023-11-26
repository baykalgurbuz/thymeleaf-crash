package com.coolapp.thymeleafapp.controller;

import com.coolapp.thymeleafapp.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> favoriteLanguages;
    @Value("${favoriteSystems}")
    private List<String> favoriteSystems;
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        Student theStudent =new Student();
        theModel.addAttribute("student",theStudent);
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages",favoriteLanguages);
        theModel.addAttribute("favoriteSystems",favoriteSystems);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println("the student :"+theStudent.getFirstName()+"-"+theStudent.getLastName());
        return "student-confirmation";
    }
}
