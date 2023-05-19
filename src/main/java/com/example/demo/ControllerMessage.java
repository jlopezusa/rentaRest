/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clmgses/Clmgs.java to edit this template
 */
package com.example.demo;

import com.example.entity.Message;
import com.example.servicios.MessageServices;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Message")
public class ControllerMessage {
    
    @Autowired
    MessageServices mg;
    
    @GetMapping("/all")
    public ArrayList<Message> getMessages(){
        return mg.getMessagesFromDB();
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message insertData(@RequestBody Message m){
        return mg.createMessage(m);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateData(@RequestBody Message m){
        if(m.getIdMessage()!= null){
            Message upm = mg.getMessage(m.getIdMessage());
            if(upm != null){
                if(m.getMessageText() != null){
                    upm.setMessageText(m.getMessageText());
                }
                if(m.getClient() != null){
                    upm.setClient(m.getClient());
                }
                if(m.getCar() != null){
                    upm.setCar(m.getCar());
                }
                return mg.createMessage(upm);
            }else{
                return m;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    public Optional<Message> getMessage(@PathVariable("id") Long id){
        return mg.getMById(id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteMessage(Message p, @PathVariable("id") Long id){
        boolean status = false;
        if(mg.getMessage(id) != null){
            status = mg.deleteMessage(id);
        }
        return status;
    }
}
