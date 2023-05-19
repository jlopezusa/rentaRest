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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation insertData(@RequestBody Reservation r){
        return rs.createReservation(r);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateData(@RequestBody Reservation r){
        if(r.getIdReservation()!= null){
            Reservation upr = rs.getReservation(r.getIdReservation());
            if(upr != null){
                if(r.getStartDate() != null){
                    upr.setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate() != null){
                    upr.setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus() != null){
                    upr.setStatus(r.getStatus());
                }
                if(r.getCar() != null){
                    upr.setCar(r.getCar());
                }
                if(r.getClient() != null){
                    upr.setClient(r.getClient());
                }
                return rs.createReservation(upr);
            }else{
                return r;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Long id){
        return rs.getRById(id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteReservation(Reservation p, @PathVariable("id") Long id){
        boolean status = false;
        if(rs.getReservation(id) != null){
            status = rs.deleteReservation(id);
        }
        return status;
    }
}
