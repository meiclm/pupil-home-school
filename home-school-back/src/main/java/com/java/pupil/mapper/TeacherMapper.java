package com.java.pupil.mapper;

import com.java.pupil.entities.Teacher;

public interface TeacherMapper {

    public Teacher findById(String id);
    public void insertTeacher(Teacher teacher);
    public void deleteTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
}
