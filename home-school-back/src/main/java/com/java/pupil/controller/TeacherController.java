package com.java.pupil.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pupil.entities.*;
import com.java.pupil.mapper.GradeClassMapper;
import com.java.pupil.mapper.MessageMapper;
import com.java.pupil.mapper.StudentMapper;
import com.java.pupil.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
>>>>>>> 10-17 22:00
import java.util.*;

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

//    查留言区
    @GetMapping("/message")
    public List<Message> getMessage(@RequestParam("t_id") String t_id){
        return messageMapper.getAllMessage(t_id);
    }
//    回复留言
    @PostMapping("/message/send")
    public int send(String t_id,String phone,String message){
        Message m=new Message();
        Teacher t=new Teacher();
        Parents p=new Parents();
        t.setId(t_id);
        m.setTeacher(t);
        p.setPhone(phone);
        m.setParents(p);
        m.setMessage(message);
        m.setSend_reci(1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        m.setSend_time(df.format(new Date()));
        System.out.println("更新的留言信息："+m);
        messageMapper.addMessage(m);
        return 1;
    }
//    教师查询学期成绩单
    /*
    {
    "15084201":{"数学":100,"语文":100,"英语"：100，"秋游":100},
    "15084201":{"数学":100,"语文":100,"英语"：100，"秋游":100},
    "15084235":{"数学":100,"语文":100,"英语"：100，"秋游":100},
    "15084232":{"数学":100,"语文":100,"英语"：100，"秋游":100}
    }
    GradeReport{grade_id=0, s_no='15084201', stuname='张田梦', coursename='语文', grade='80'}
    GradeReport{grade_id=0, s_no='15084201', stuname='张田梦', coursename='数学', grade='90'}
    GradeReport{grade_id=0, s_no='15084201', stuname='张田梦', coursename='英语', grade='60'}
    GradeReport{grade_id=0, s_no='15084101', stuname='单紫嫣', coursename='语文', grade='66'}
    GradeReport{grade_id=0, s_no='15084101', stuname='单紫嫣', coursename='数学', grade='78'}
    GradeReport{grade_id=0, s_no='15084101', stuname='单紫嫣', coursename='英语', grade='100'}
    GradeReport{grade_id=0, s_no='15084235', stuname='孔德林', coursename='语文', grade='85'}
    GradeReport{grade_id=0, s_no='15084235', stuname='孔德林', coursename='数学', grade='90'}
    GradeReport{grade_id=0, s_no='15084235', stuname='孔德林', coursename='英语', grade='90'}
    GradeReport{grade_id=0, s_no='15084232', stuname='黄海波', coursename='语文', grade='92'}
    GradeReport{grade_id=0, s_no='15084232', stuname='黄海波', coursename='数学', grade='91'}
    GradeReport{grade_id=0, s_no='15084232', stuname='黄海波', coursename='英语', grade='90'}
    */
    @GetMapping("/teacher/allgrade")
    public Map<String,Map<String,String>>  getGrade(@RequestParam("term") String term){
        List<GradeReport> list = gradeClassMapper.findAllGradeByterm(term);

        Map<String,Map<String,String>> grade_list = new HashMap<>();
        int size = list.size();
        Set<String> id_set = new TreeSet<>();
        for (GradeReport gradeReport:list){
            id_set.add(gradeReport.getS_no());
        }
        System.out.println(id_set);
        for (String s_no:id_set){
            Map<String,String> grade_map = new HashMap<>();//coursename:grade
            for(GradeReport gradeReport:list){
                if (gradeReport.getS_no().equals(s_no)){
                    grade_map.put(gradeReport.getCoursename(),gradeReport.getGrade());
                }
            }
            grade_list.put(s_no,grade_map);


        }
//        System.out.println(grade_list);
        return grade_list;
    }
}
