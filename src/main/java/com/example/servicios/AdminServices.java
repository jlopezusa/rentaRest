/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.repository.IAdminDao;
import com.example.entity.Admin;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javis
 */
@Service
public class AdminServices {
    
    @Autowired
    IAdminDao adminDao;
    
    public ArrayList<Admin> getAdminsFromDB(){
        return (ArrayList<Admin>)adminDao.findAll();
    }
    
    public Admin createAdmin(Admin a){
        return adminDao.save(a);
    }
    
    public Optional<Admin> getAById(Long id){
        return adminDao.findById(id);
    }
    
    public Admin getAdmin(Long id){
        return adminDao.findById(id).orElse(null);
    }
    
    public boolean deleteAdmin(Long id){
        try{
            adminDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
