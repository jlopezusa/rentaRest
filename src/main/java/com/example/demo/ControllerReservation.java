/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clrsses/Clrss.java to edit this template
 */
package com.example.demo;

import com.example.entity.Reservation;
import com.example.servicios.ReservationServices;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Reservation")
public class ControllerReservation {
    
    @Autowired
    ReservationServices rs;
    
    @GetMapping("/all")
    public ArrayList<Reservation> getReservations(){
        return rs.getReservationsFromDB();
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/all")
    public Reservation insertData(@RequestBody Reservation r){
        return rs.createReservation(r);
    }
    
    @PutMapping("/update/{id}")
    public Reservation updateData(@PathVariable("id") Long id,@RequestBody Reservation r){
        Reservation upr = rs.getReservation(id);
        upr.setStartDate(r.getStartDate());
        upr.setDevolutionDate(r.getDevolutionDate());
        upr.setStatus(r.getStatus());
        upr.setCar(r.getCar());
        upr.setClient(r.getClient());
        return rs.createReservation(upr);
    }
    
    @GetMapping("/get/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Long id){
        return rs.getRById(id);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteReservation(Reservation p, @PathVariable("id") Long id){
        boolean status = rs.deleteReservation(id);
        if(status){
            return "Reservacion eliminada con exito";
        }else{
            return "No se puede eliminar reservacion";
        }
    }
}
