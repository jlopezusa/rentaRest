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
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*")
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
    public Car insertData(@RequestBody Car c){
        return cr.createCar(c);
    }
    
    @PutMapping("/update/{id}")
    public Car updateData(@PathVariable("id") Long id,@RequestBody Car c){
        Car ucar = cr.getCar(id);
        ucar.setName(c.getName());
        ucar.setBrand(c.getBrand());
        ucar.setYear(c.getYear());
        ucar.setDescription(c.getDescription());
        return cr.createCar(ucar);
    }
    
    @GetMapping("/get/{id}")
    public Optional<Car> getCar(@PathVariable("id") Long id){
        return cr.getCById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteCar(Car p, @PathVariable("id") Long id){
        boolean status = cr.deleteCar(id);
        if(status){
            return "Carro eliminado con exito";
        }else{
            return "No se puede eliminar carro";
        }
    }
}
