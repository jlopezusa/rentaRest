/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clcrses/Clcrs.java to edit this template
 */
package com.example.demo;

import com.example.servicios.CarServices;
import com.example.entity.Car;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Car")
public class ControllerCar {
    
    @Autowired
    CarServices cr;
    
    @GetMapping("/all")
    public ArrayList<Car> getCars(){
        return cr.getCarsFromDB();  
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car insertData(@RequestBody Car c){
        return cr.createCar(c);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car updateData(@RequestBody Car c){
        if(c.getIdCar() != null){
            Car ucar = cr.getCar(c.getIdCar());
            if(ucar != null){
                if(c.getName() != null){
                    ucar.setName(c.getName());
                }
                if(c.getBrand() != null){
                    ucar.setBrand(c.getBrand());
                }
                ucar.setYear(c.getYear());
                if(c.getDescription()!= null){
                    ucar.setDescription(c.getDescription());
                }
                return cr.createCar(ucar);
            }else{
                return c;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") Long id){
        return cr.getCById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCar(Car p, @PathVariable("id") Long id){
        boolean status = false;
        if(cr.getCar(id) != null){
            status = cr.deleteCar(id);
        }
        return status;
    }
}
