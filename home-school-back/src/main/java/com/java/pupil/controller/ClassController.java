package com.java.pupil.controller;

import com.java.pupil.entities.GradeClass;
import com.java.pupil.mapper.GradeClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {
    @Autowired
    private GradeClassMapper gradeClassMapper;

//    查老师教的管理的班级
    @GetMapping("/teaching/class")
    public List<GradeClass> findAllClass(@RequestParam("t_id") String t_id){
        return gradeClassMapper.findAllClassByTeacher(t_id);
    }
}
