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
@RequestMapping("/api/Reservation")
public class ControllerReservation {
    
    @Autowired
    ReservationServices rs;
    
    @GetMapping("/all")
    public ArrayList<Reservation> getReservations(){
        return rs.getReservationsFromDB();
    }
    
    /*public ResponseEntity<List> getPeople(){
        ArrayList al = rs.getPeopleFromDB();
        return ResponseEntity.ok(al);
    }*/
    
    //@CrossOrigin(origins = "*")
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    public Reservation insertData(@RequestBody Reservation r){
        return rs.createReservation(r);
    }
    
    @PutMapping("/update/{id}")
    public Reservation updateData(@PathVariable("id") Long id,@RequestBody Reservation r){
        Reservation upr = rs.getReservation(id);
        upr.setStartDate(r.getStartDate());
        upr.setDevolutionDate(r.getDevolutionDate());
        upr.setStatus(r.getStatus());
        upr.setCarId(r.getCarId());
        upr.setClientId(r.getClientId());
        return rs.createReservation(upr);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Long id){
        return rs.getRById(id);
    }
    
    @CrossOrigin(origins = "*")
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
