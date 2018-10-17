package com.java.pupil.entities;

public class GradeReport {
  private int grade_id;
  private String id;
  private String stuname;
  private String coursename;
  private String grade;

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getS_no() {
        return id;
    }

    public void setS_no(String s_no) {
        this.id = s_no;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "GradeReport{" +
                "grade_id=" + grade_id +
                ", s_no='" + id + '\'' +
                ", stuname='" + stuname + '\'' +
                ", coursename='" + coursename + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
