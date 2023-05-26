/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clrsses/Clrss.java to edit this template
 */
package com.example.demo;

import com.example.entity.Client;
import com.example.entity.DTO.CompletedAndCancelled;
import com.example.entity.DTO.TotalAndClient;
import com.example.entity.Reservation;
import com.example.servicios.ReservationServices;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("fecha1") String fechaA, @PathVariable("fecha2") String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);
        }catch(ParseException exception){
            exception.printStackTrace();
        }
        if(a.before(b)){
            return rs.getReservationsBetweenDates(a, b);
        }else{
            return new ArrayList<>();
        }
    }
    
    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationStatusReport(){
        List<Reservation> completed = rs.getReservationsByStatus("completed");
        List<Reservation> cancelled = rs.getReservationsByStatus("cancelled");
        Long cantidadCompletada = (long) completed.size();
        Long cantidadCancelada = (long) cancelled.size();
        CompletedAndCancelled respuesta = new CompletedAndCancelled(cantidadCompletada,cantidadCancelada);
        return respuesta;
    }
    
    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = rs.getTotalReservationsByClient();
        for(Object[] pareja: reporte){
            respuesta.add(new TotalAndClient((Long) pareja[1], (Client) pareja[0]));
        }
        return respuesta;
    }
}
