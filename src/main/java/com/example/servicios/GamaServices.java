/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.repository.IGamaDao;
import com.example.entity.Gama;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javis
 */
@Service
public class GamaServices {
    
    @Autowired
    IGamaDao gamaDao;
    
    public ArrayList<Gama> getGamasFromDB(){
        return (ArrayList<Gama>)gamaDao.findAll();
    }
    
    public Gama createGama(Gama g){
        return gamaDao.save(g);
    }
    
    public Optional<Gama> getGById(Long id){
        return gamaDao.findById(id);
    }
    
    public Gama getGama(Long id){
        return gamaDao.findById(id).orElse(null);
    }
    
    public boolean deleteGama(Long id){
        try{
            gamaDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
