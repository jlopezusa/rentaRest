/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.entity.DTO.TotalAndClient;
import com.example.repository.IReservationDao;
import com.example.entity.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javis
 */
@Service
public class ReservationServices {
    
    @Autowired
    IReservationDao reservationDao;
    
    public ArrayList<Reservation> getReservationsFromDB(){
        return (ArrayList<Reservation>)reservationDao.findAll();
    }
    
    public Reservation createReservation(Reservation r){
        r.setStatus("created");
        return reservationDao.save(r);
    }
    
    public Optional<Reservation> getRById(Long id){
        return reservationDao.findById(id);
    }
    
    public Reservation getReservation(Long id){
        return reservationDao.findById(id).orElse(null);
    }
    
    public boolean deleteReservation(Long id){
        try{
            reservationDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationDao.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }
    
    public List<Reservation> getReservationsByStatus(String status){
        return reservationDao.findAllByStatus(status);
    }
    
    public List<Object[]> getTotalReservationsByClient(){
        return reservationDao.getTotalReservationsByClient();
    }
}
