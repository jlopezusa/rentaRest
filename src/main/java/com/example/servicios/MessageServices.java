/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.repository.IMessageDao;
import java.util.ArrayList;
import com.example.entity.Message;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javis
 */
@Service
public class MessageServices {
    
    @Autowired
    IMessageDao messageDao;
    
    public ArrayList<Message> getMessagesFromDB(){
        return (ArrayList<Message>)messageDao.findAll();
    }
    
    public Message createMessage(Message m){
        return messageDao.save(m);
    }
    
    public Optional<Message> getMById(Long id){
        return messageDao.findById(id);
    }
    
    public Message getMessage(Long id){
        return messageDao.findById(id).orElse(null);
    }
    
    public boolean deleteMessage(Long id){
        try{
            messageDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
