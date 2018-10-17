package com.java.pupil.entities;

public class Message {
    private Integer id;
    private Teacher teacher;
    private Parents parents;
    private String message;
    private String send_time;
    private Integer send_reci;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public String getMessage()

    {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public Integer getSend_reci() {
        return send_reci;
    }

    public void setSend_reci(Integer send_reci) {
        this.send_reci = send_reci;
    }
}
