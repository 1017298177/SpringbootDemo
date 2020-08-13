package com.lcm.springbootdemo01.modules.test.controller;


import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.Student;
import com.lcm.springbootdemo01.modules.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/student", consumes = "application/json")
    public Result<Student> insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }


    @GetMapping(value = "/student", consumes = "application/json")
    public Page<Student> getStudentBySearchVo(@RequestBody SearchVo searchVo) {
        return studentService.getStudentBySearchVo(searchVo);
    }

    @GetMapping("/students")
    public List<Student> getStudentByStudentName(
            @RequestParam String studentName,
            @RequestParam(required = false, defaultValue = "0") Integer cardId) {
        return studentService.getStudentByStudentName(studentName, cardId);
    }


}
