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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Admin")
public class ControllerAdmin {
    
    @Autowired
    AdminServices as;
    
    @GetMapping("/all")
    public ArrayList<Admin> getAdmins(){
        return as.getAdminsFromDB();
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin insertData(@RequestBody Admin a){
        return as.createAdmin(a);
    }
    
    @PutMapping("/update/{id}")
    public Admin updateData(@PathVariable("id") Long id,@RequestBody Admin a){
        if(a.getIdAdmin() != null){
            Admin ad = as.getAdmin(id);
            if(ad != null){
                if(a.getName() != null){
                    ad.setName(a.getName());
                }
                if(ad.getEmail() != null){
                    ad.setEmail(a.getEmail());
                }
                if(ad.getPassword()!= null){
                    ad.setPassword(a.getPassword());
                }
                return as.createAdmin(ad);
            }else{
                return a;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") Long id){
        return as.getAById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public Boolean deleteAdmin(Admin p, @PathVariable("id") Long id){
        boolean status = false;
        if(as.getAdmin(id) != null){
            status = as.deleteAdmin(id);
        }
        return status;
    }
}
