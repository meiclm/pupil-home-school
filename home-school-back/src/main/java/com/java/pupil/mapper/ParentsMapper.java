package com.java.pupil.mapper;

import com.java.pupil.entities.Parents;
import com.java.pupil.entities.StudentParent;

import java.util.List;

public interface ParentsMapper {

    public Parents findByPhone(String username);
    public List<StudentParent> findByOpenId(String opoenId);
    public void updateParent(Parents parents);
    public void insertParent(Parents parents);
    public Parents findParentsByOpenId(String openId);
}
