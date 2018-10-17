package com.java.pupil.mapper;

import com.java.pupil.entities.CourseGrade;
import com.java.pupil.entities.Parents;
import com.java.pupil.entities.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    public Student findStudentById(String id);
//    根据父母的手机找到学生
    public List<Student> findByParentPhone(String phone);
//    根据 班级842 或者 150842__查询学生
    public List<Student> findByClass(@Param("classNum") String classNum);

//    查找该学生的所有成绩
    public List<CourseGrade> findAllScore(String s_no);
}
