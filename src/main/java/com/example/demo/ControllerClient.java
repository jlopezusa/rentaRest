/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clcsses/Clcss.java to edit this template
 */
package com.example.demo;

import com.example.servicios.ClientServices;
import com.example.entity.Client;
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
@RequestMapping("/api/Client")
public class ControllerClient {
    
    @Autowired
    ClientServices cs;
    
    @GetMapping("/all")
    public ArrayList<Client> getClients(){
        return cs.getClientsFromDB();
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertData(@RequestBody Client c){
        return cs.createClient(c);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateData(@RequestBody Client c){
        if(c.getIdClient() != null){
            Client ucl = cs.getClient(c.getIdClient());
            if(ucl != null){
                if(c.getName() != null){
                    ucl.setName(c.getName());
                }
                if(c.getPassword() != null){
                    ucl.setPassword(c.getPassword());
                }
                if(c.getEmail() != null){
                    ucl.setEmail(c.getEmail());
                }
                ucl.setAge(c.getAge());
                return cs.createClient(ucl);
            }else{
                return c;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Client> getClient(@PathVariable("id") Long id){
        return cs.getClById(id);
    }
    
    @DeleteMapping("/{id}")
    public Boolean deleteClient(Client p, @PathVariable("id") Long id){
        boolean status = false;
        if(cs.getClient(id) != null){
            status = cs.deleteClient(id);
        }
        return status;
    }
}
