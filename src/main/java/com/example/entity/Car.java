/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Javis
 */
@Entity
@Table(name="car")
public class Car implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCar;
    private String name;
    private String brand;
    private int year;  
    private String description;
    
    @ManyToOne()
    @JoinColumn(name="gamaId")
    @JsonIgnoreProperties("cars")
    private Gama gama;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="car")
    @JsonIgnoreProperties("car")
    private List<Message> messages = new ArrayList<Message>();
    
    @OneToMany(mappedBy="car")
    @JsonIgnoreProperties("car")
    private List<Reservation> reservations = new ArrayList<Reservation>();
    

    public Car(){
    }

    public Car(String name, String brand, int year, String description, Gama gama) {
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.gama = gama;
    }

    public Car(Long idCar, String name, String brand, int year, String description, Gama gama) {
        this.idCar = idCar;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.gama = gama;
    }
    /**
     * @return the id
     */
    public Long getIdCar() {
        return idCar;
    }

    /**
     * @param id the id to set
     */
    public void setIdCar(Long id) {
        this.idCar = id;
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
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
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
     * @return the gama
     */
    public Gama getGama() {
        return gama;
    }

    /**
     * @param gama the gama to set
     */
    public void setGama(Gama gama) {
        this.gama = gama;
    }

    /**
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
