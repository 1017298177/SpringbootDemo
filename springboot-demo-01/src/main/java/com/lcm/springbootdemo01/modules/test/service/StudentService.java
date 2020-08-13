package com.lcm.springbootdemo01.modules.test.service;

import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Result<Student> insertStudent(Student student);

    Page<Student> getStudentBySearchVo(SearchVo searchVo);

    List<Student> getStudentByStudentName(String studentName,int cardId);
}
