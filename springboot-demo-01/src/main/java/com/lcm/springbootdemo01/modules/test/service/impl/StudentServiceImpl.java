package com.lcm.springbootdemo01.modules.test.service.impl;

import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.Student;
import com.lcm.springbootdemo01.modules.test.repository.StudentRepository;
import com.lcm.springbootdemo01.modules.test.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Result<Student> insertStudent(Student student) {
        studentRepository.save(student);
        return new Result<>("insert success",Result.ResultStatus.SUCCESS.status);
    }

    @Override
    public Page<Student> getStudentBySearchVo(SearchVo searchVo) {
        //排序字段
        String orderBy = StringUtils.isBlank(searchVo.getOrderBy())?"studentId":searchVo.getOrderBy();
        //排序方式
        Sort.Direction direction = StringUtils.isBlank(searchVo.getSort())||"desc".equals(searchVo.getSort())?Sort.Direction.DESC:Sort.Direction.ASC;
        //排序对象
        Sort sort = Sort.by(direction,orderBy);
       //获取分页对象
        Pageable pageable = PageRequest.of(searchVo.getCurrentPage()-1,searchVo.getPageSize(),sort);
       //匹配规则
        Student student = new Student() ;
        student.setStudentName(searchVo.getKeyWord());
        ExampleMatcher matcher= ExampleMatcher.matching()
                .withMatcher("studentName",match -> match.contains())
                .withIgnorePaths("studentId");
        //查询条件对象
        Example<Student> example = Example.of(student,matcher);
        return studentRepository.findAll(example,pageable);
    }

    @Override
    public List<Student> getStudentByStudentName(String studentName,int cardId) {

     if (cardId > 0) {
            return studentRepository.getStudentsByParams(studentName, cardId);
        } else {
//        return Optional
//                .ofNullable(studentRepository.findByStudentName(studentName))
//                .orElse(Collections.emptyList());
//        return Optional
//                .ofNullable(studentRepository.findByStudentNameLike(
//                        String.format("%s%S%s", "%", studentName, "%")))
//                .orElse(Collections.emptyList());
            return Optional
                    .ofNullable(studentRepository.findTop2ByStudentNameLike(
                            String.format("%s%S%s", "%", studentName, "%")))
                    .orElse(Collections.emptyList());
        }
    }

}
