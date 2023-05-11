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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*")
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
    public Message insertData(@RequestBody Message m){
        return mg.createMessage(m);
    }
    
    @PutMapping("/update/{id}")
    public Message updateData(@PathVariable("id") Long id,@RequestBody Message m){
        Message upm = mg.getMessage(id);
        upm.setMessageText(m.getMessageText());
        upm.setClient(m.getClient());
        upm.setCar(m.getCar());
        return mg.createMessage(upm);
    }
    
    @GetMapping("/get/{id}")
    public Optional<Message> getMessage(@PathVariable("id") Long id){
        return mg.getMById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteMessage(Message p, @PathVariable("id") Long id){
        boolean status = mg.deleteMessage(id);
        if(status){
            return "Mensaje eliminada con exito";
        }else{
            return "No se puedo eliminar Mensaje";
        }
    }
}
