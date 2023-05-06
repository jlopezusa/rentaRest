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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author Javis
 */
@RestController
@RequestMapping("/api/Message")
public class ControllerMessage {
    
    @Autowired
    MessageServices mg;
    
    @GetMapping("/all")
    public ArrayList<Message> getMessages(){
        return mg.getMessagesFromDB();
    }
    
    /*public ResponseEntity<List> getPeople(){
        ArrayList al = ps.getPeopleFromDB();
        return ResponseEntity.ok(al);
    }*/
    
    //@CrossOrigin(origins = "*")
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
        upm.setClientId(m.getClientId());
        upm.setCarId(m.getCarId());
        return mg.createMessage(upm);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public Optional<Message> getMessage(@PathVariable("id") Long id){
        return mg.getMById(id);
    }
    
    @CrossOrigin(origins = "*")
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
