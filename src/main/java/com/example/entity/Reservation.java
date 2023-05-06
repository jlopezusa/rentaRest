/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 *
 * @author Javis
 */
@Entity
@Table(name="reservation")
public class Reservation implements Serializable{
    
    @Id
    private Long id;
    private Date startDate;
    private Date devolutionDate;
    private String status;
    private Long carId;
    private Long clientId;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the devolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * @param devolutionDate the devolutionDate to set
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the carId
     */
    public Long getCarId() {
        return carId;
    }

    /**
     * @param carId the carId to set
     */
    public void setCarId(Long carId) {
        this.carId = carId;
    }

    /**
     * @return the clientId
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    
}
