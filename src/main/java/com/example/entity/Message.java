/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Javis
 */
@Entity
@Table(name="message")
public class Message implements Serializable{
    
    @Id
    private Long Id;
    private String messageText;
    private Long carId;
    private Long clientId;

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
