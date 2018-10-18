package com.java.pupil.mapper;

import com.java.pupil.entities.Message;

import java.util.List;

public interface MessageMapper {
    public List<Message> getAllMessage(String t_id);
    public List<Message> findMesageToParent(String p_id);
    public void addMessage(Message message);
}
