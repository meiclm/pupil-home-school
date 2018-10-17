package com.java.pupil.controller;

import com.java.pupil.entities.Parents;
import com.java.pupil.entities.Student;
import com.java.pupil.entities.Teacher;
import com.java.pupil.mapper.ParentsMapper;
import com.java.pupil.mapper.StudentMapper;
import com.java.pupil.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ParentsMapper parentsMapper;
    @Autowired
    StudentMapper studentMapper;
//登陆验证
    @PostMapping("/sign-in")
    public int signIn(String username,String password,int status){
        if (status==1||status==0){
            Teacher teacher=teacherMapper.findById(username);
            if (teacher!=null&&teacher.getPassword().equals(password)){
                return 1;
            }
        }else {
//            查父母账号
            Parents parents =parentsMapper.findByPhone(username);
            if (parents!=null&&parents.getPassword().equals(password)){
                return 1;
            }
        }
        return -1;
    }

//    家长注册验证
    public int signUp(Parents parents){
        List<Student> studentList=studentMapper.findByParentPhone(parents.getPhone());
        if (studentList.size()<=0){
            return -1;
        }else {
            parentsMapper.insertParent(parents);
            return 1;
        }
    }
//    老师注册,老师的id（工号）由管理员写入数据库
    @GetMapping("/teacher/sign-in")
    public int signUp(String username,String password,String phone){
        Teacher newTeacher=teacherMapper.findById(username);
        if (newTeacher!=null){
            newTeacher.setPassword(password);
            newTeacher.setTelephone(phone);
            teacherMapper.updateTeacher(newTeacher);
            return 1;
        }else {
            System.out.println("没有查到该老师工号！");
            return -1;
        }
    }
}
