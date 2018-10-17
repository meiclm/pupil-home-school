package com.java.pupil.mapper;

import com.java.pupil.entities.CourseGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseGradeMapper {
//    找到该学期的学生成绩
    public List<CourseGrade> findByTerm(@Param("s_no") String s_no,@Param("term") String term);
//    找到该学生所有学期的成绩
    public List<CourseGrade> findAllTerm(@Param("s_no") String s_no);
//    查找该学期的不及格成绩
    public List<CourseGrade> findLowGrade(@Param("s_no") String s_no,@Param("term") String term);
    public List<CourseGrade> findAllLowGrade(@Param("s_no") String s_no);
}
