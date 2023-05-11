/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.repository.ICarDao;
import com.example.entity.Car;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Javis
 */
@Service
public class CarServices {
    
    @Autowired
    ICarDao carDao;
    
    public ArrayList<Car> getCarsFromDB(){
        return (ArrayList<Car>)carDao.findAll();
    }
    
    public Car createCar(Car c){
        return carDao.save(c);
    }
    
    public Optional<Car> getCById(Long id){
        return carDao.findById(id);
    }
    
    public Car getCar(Long id){
        return carDao.findById(id).orElse(null);
    }
    
    public boolean deleteCar(Long id){
        try{
            carDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
