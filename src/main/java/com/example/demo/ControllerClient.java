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
@RequestMapping("/api/Client")
public class ControllerClient {
    
    @Autowired
    ClientServices cs;
    
    @GetMapping("/all")
    public ArrayList<Client> getClients(){
        return cs.getClientsFromDB();
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
    public Client insertData(@RequestBody Client c){
        return cs.createClient(c);
    }
    
    @PutMapping("/update/{id}")
    public Client updateData(@PathVariable("id") Long id,@RequestBody Client c){
        Client ucl = cs.getClient(id);
        ucl.setName(c.getName());
        ucl.setPassword(c.getPassword());
        ucl.setAge(c.getAge());
        return cs.createClient(ucl);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public Optional<Client> getClient(@PathVariable("id") Long id){
        return cs.getClById(id);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public String deleteClient(Client p, @PathVariable("id") Long id){
        boolean status = cs.deleteClient(id);
        if(status){
            return "Cliente eliminado con exito";
        }else{
            return "No se puede eliminar cliente";
        }
    }
}
