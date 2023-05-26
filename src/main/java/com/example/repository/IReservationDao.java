/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repository;

import com.example.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author Javis
 */
@Repository
public interface IReservationDao extends JpaRepository<Reservation, Long> {
    
    //Reporte 1
    //SELECT * FROM reservation WHERE start_date AFTER fechauser AND devolution_date BEFORE fechauser
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);
    
    //Reporte 2
    //SELECT * FROM reservation WHERE status = "valor"
    public List<Reservation> findAllByStatus(String status);
    
    //Reporte 3
    //SELECT clientId, COUNT(clientId) FROM reservation GROUP BY clientId ORDER BY COUNT(clientId) DESC 
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();
}
