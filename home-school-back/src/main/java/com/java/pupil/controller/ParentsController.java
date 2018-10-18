package com.java.pupil.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.pupil.entities.*;
import com.java.pupil.mapper.CourseGradeMapper;
import com.java.pupil.mapper.MessageMapper;
import com.java.pupil.mapper.ParentsMapper;
import com.java.pupil.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.GroupSequence;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ParentsController {
    @Autowired
    private ParentsMapper parentsMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseGradeMapper courseGradeMapper;
    @Autowired
    private MessageMapper messageMapper;

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
//    学生与父母关联
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

//    查询父母信息openID
    @GetMapping("/parent")
    public  Parents  findParentsByOpenId(@RequestParam("open_id") String open_id){
       Parents parents = parentsMapper.findParentsByOpenId(open_id);
       return parents;
    }
//    写留言给班主任
//    看期末评语
//    查询教师给父母的留言
    @GetMapping("/parent/message")
    public List<Message> findMessageToParent(@RequestParam("p_id") String p_id){
       List<Message> list = messageMapper.findMesageToParent(p_id);
       System.out.println(list);
       return  list;
    }
//    父母回复教师留言
    @PostMapping("/parent/message-send")
    public Integer MessageToTeacher(@RequestParam String t_id,@RequestParam String message,@RequestParam String p_id){
        String send_reci = "2";
        Message messageToTeacher = new Message();
        Teacher teacher = new Teacher();
        Parents parents = new Parents();
        teacher.setId(t_id);
        parents.setPhone(p_id);
        messageToTeacher.setSend_reci(2);
        messageToTeacher.setMessage(message);
        messageToTeacher.setTeacher(teacher);
        messageToTeacher.setParents(parents);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        messageToTeacher.setSend_time(df.format(new Date()));
        int result = messageMapper.addMessageToTeacher(messageToTeacher);
        System.out.println(result);
        return result;
    }
}
