package com.java.pupil.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pupil.entities.GradeClass;
import com.java.pupil.entities.Message;
import com.java.pupil.entities.Student;
import com.java.pupil.entities.Teacher;
import com.java.pupil.mapper.GradeClassMapper;
import com.java.pupil.mapper.MessageMapper;
import com.java.pupil.mapper.StudentMapper;
import com.java.pupil.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GradeClassMapper gradeClassMapper;
    @Autowired
    private MessageMapper messageMapper;

//    管理员添加教师
    @PostMapping("/admin/insert")
    public int insertTeacher(Teacher teacher){
        Teacher already_teacher=teacherMapper.findById(teacher.getId());
        if (already_teacher!=null){
            return -1;
        }else {
            teacherMapper.insertTeacher(teacher);
            return 1;
        }
    }

//    老师个人信息
    @GetMapping("/teacher")
    public Teacher findTeacher(@RequestParam("id") String id){
        Teacher teacher=teacherMapper.findById(id);
        return teacher;
    }

    //    老师信息更新
    @PostMapping("/teacher/update")
    public int updateTeacher(String t_id,String name,String telephone,String wechat,String email){
        Teacher teacher=teacherMapper.findById(t_id);
        if (teacher!=null){
            teacher.setName(name);
            teacher.setTelephone(telephone);
            teacher.setWechat(wechat);
            teacher.setEmail(email);
            teacherMapper.updateTeacher(teacher);
            return 1;
        }else {
            return -1;
        }
    }


//    查一个年级的班级1
    @GetMapping("/teacher/grade-class")
    public PageInfo<GradeClass> findGradeClass(@RequestParam("describe")int describe,@RequestParam("start") int start){
        PageHelper.startPage(start, 20, "id desc");
        List<GradeClass> classList=gradeClassMapper.findGradeClassByDescribe(Integer.valueOf(describe));
        PageInfo<GradeClass> pageInfo=new PageInfo<>(classList);
        return pageInfo;
    }


//    查一个班级的学生1
    @GetMapping("/teacher/class-students")
    public PageInfo<Student> findStudentByClass(@RequestParam("classNum") String classNum,@RequestParam("start") int start){
        PageHelper.startPage(start, 20, "id desc");
        List<Student> studentList=studentMapper.findByClass(classNum);
        PageInfo<Student> page = new PageInfo<>(studentList);
        return page;
    }
//    更新一门成绩

//    插入一门成绩

//    查留言区
    @GetMapping("/message")
    public List<Message> getMessage(@RequestParam("t_id") String t_id){
        return messageMapper.getAllMessage(t_id);
    }
//    回复留言
    @PostMapping("/message/send")
    public int send(Message message){
        messageMapper.addMessage(message);
        return 1;
    }
}
