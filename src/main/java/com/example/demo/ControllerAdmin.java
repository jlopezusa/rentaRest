/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import com.example.servicios.AdminServices;
import com.example.entity.Admin;
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
@RequestMapping("/api/Admin")
public class ControllerAdmin {
    
    @Autowired
    AdminServices as;
    
    @GetMapping("/all")
    public ArrayList<Admin> getAdmins(){
        return as.getAdminsFromDB();
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
    public Admin insertData(@RequestBody Admin a){
        return as.createAdmin(a);
    }
    
    @PutMapping("/update/{id}")
    public Admin updateData(@PathVariable("id") Long id,@RequestBody Admin a){
        Admin ad = as.getAdmin(id);
        ad.setName(a.getName());
        ad.setEmail(a.getEmail());
        ad.setPassword(a.getPassword());
        return as.createAdmin(ad);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") Long id){
        return as.getAById(id);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(Admin p, @PathVariable("id") Long id){
        boolean status = as.deleteAdmin(id);
        if(status){
            return "Persona eliminada con exito";
        }else{
            return "No se puedo eliminar persona";
        }
    }
}
