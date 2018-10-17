package com.java.pupil.entities;

public class GradeClass {
    private String classNo;
    private Teacher teacher;
    private Integer count;
    private Integer describe;


    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDescribe() {
        return describe;
    }

    public void setDescribe(Integer describe) {
        this.describe = describe;
    }
}
