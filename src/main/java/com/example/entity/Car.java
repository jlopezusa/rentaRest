/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.sql.Date;

/**
 *
 * @author Javis
 */
@Entity
@Table(name="car")
public class Car implements Serializable{
    
    @Id
    private Long id;
    private String name;
    private String brand;
    private Long year;  
    private String description;
    private Long gamaId;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the year
     */
    public Long getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Long year) {
        this.year = year;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the gamaId
     */
    public Long getGamaId() {
        return gamaId;
    }

    /**
     * @param gamaId the gamaId to set
     */
    public void setGamaId(Long gamaId) {
        this.gamaId = gamaId;
    }
    
    
    
    
}
