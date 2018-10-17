package com.java.pupil.mapper;

import com.java.pupil.entities.GradeClass;
import com.java.pupil.entities.GradeReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeClassMapper {
//    通过三年级/六年级这样查一个年级的班级 如：1=>一年级
    public List<GradeClass> findGradeClassByDescribe(Integer describe);
    public List<GradeReport> findAllGradeByterm(String term);

}
