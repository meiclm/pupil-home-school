package com.java.pupil.controller;

import com.java.pupil.entities.CourseGrade;
import com.java.pupil.entities.Student;
import com.java.pupil.mapper.CourseGradeMapper;
import com.java.pupil.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseGradeMapper courseGradeMapper;

//    该学生全部成绩
    @GetMapping("/student/allTerm")
    public List<CourseGrade> findAllScore(@RequestParam("s_no") String s_no){
        List<CourseGrade> gradeList=courseGradeMapper.findAllTerm(s_no);
        return gradeList;
    }
}

