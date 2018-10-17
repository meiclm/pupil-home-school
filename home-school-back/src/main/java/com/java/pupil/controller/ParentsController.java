package com.java.pupil.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pupil.entities.CourseGrade;
import com.java.pupil.entities.Parents;
import com.java.pupil.entities.Student;
import com.java.pupil.entities.StudentParent;
import com.java.pupil.mapper.CourseGradeMapper;
import com.java.pupil.mapper.ParentsMapper;
import com.java.pupil.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentsController {
    @Autowired
    private ParentsMapper parentsMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseGradeMapper courseGradeMapper;

//    查询学生该学期成绩1
   @GetMapping("/student/term")
    public List<CourseGrade> findGrade(@RequestParam("s_no") String s_no, @RequestParam("term") String term){
        List<CourseGrade> gradeList=courseGradeMapper.findByTerm(s_no,term);
        if (gradeList.size()>0){
            return gradeList;
        }else {
            return null;
        }
    }

//    查询学生往期成绩1
    @GetMapping("/student/all-term")
    public PageInfo<CourseGrade> findGrades(@RequestParam("s_no") String s_no, @RequestParam("start")int start,@RequestParam("page")int page){
        PageHelper.startPage(start,page,"grade desc");
        List<CourseGrade> gradeList=courseGradeMapper.findAllTerm(s_no);
        PageInfo<CourseGrade> info=new PageInfo<>(gradeList);
        return info;
    }
//    修改个人信息
    @PostMapping("/parents/update-info")
    public int update(Parents parents){
        parentsMapper.updateParent(parents);
        return 1;
    }

//    查父母信息1
    @GetMapping("/parents")
    public Parents findParents(@RequestParam("s_no") String s_no){
        Student student=studentMapper.findStudentById(s_no);
        if (student!=null){
            Parents parents=parentsMapper.findByPhone(student.getPhone());
            if (parents!=null){
                return parents;
            }else {
                System.out.println("该学生的家长还没有注册账号！");
            }
        }
        return null;
    }
    @GetMapping("/parent/students")
    public List<StudentParent> findByOpenId(@RequestParam("open_id") String open_id){
       List<StudentParent> list = parentsMapper.findByOpenId(open_id);
       if (list!=null){
           return list;
       }
       else{
           return null;
       }
    }
//    写留言给班主任
//    看期末评语
}