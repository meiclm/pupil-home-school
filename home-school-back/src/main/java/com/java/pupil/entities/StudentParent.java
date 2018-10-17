package com.java.pupil.entities;

public class StudentParent {
    /*parent与student关联*/
    private  String id;
    private String stuname;
    private String birthday;
    private String phone;
    private String parname;
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParname() {
        return parname;
    }

    public void setParname(String parname) {
        this.parname = parname;
    }
}
