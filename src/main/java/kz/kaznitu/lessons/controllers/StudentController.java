package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Student;
import kz.kaznitu.lessons.models.Teacher;
import kz.kaznitu.lessons.reposotories.StudentRepository;
import kz.kaznitu.lessons.reposotories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private TeacherRepository teacherRepository ;

    @GetMapping("/all")
    public String allTeachers2(Model model){
        List<Teacher> teachers = (List<Teacher>) teacherRepository.findAll();
        model.addAttribute("students", teachers) ;
        return "students" ;
    }

}