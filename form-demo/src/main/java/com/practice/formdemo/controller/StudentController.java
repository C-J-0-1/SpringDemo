package com.practice.formdemo.controller;

import com.practice.formdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/form")
    public String formPage(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        List<String> branchList = Arrays.asList("Computer Engineering", "Electrical Engineering", "Mechanical Engineering", "Civil Engineering");
        model.addAttribute("branchList", branchList);
        return "student-form";
    }

    @PostMapping("/form")
    public String formSubmit(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<String> branchList = Arrays.asList("Computer Engineering", "Electrical Engineering", "Mechanical Engineering", "Civil Engineering");
            model.addAttribute("branchList", branchList);
            return "student-form";
        }
        else
            return "registration-success";
    }
}
