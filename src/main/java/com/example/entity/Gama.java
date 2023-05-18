/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Javis
 */
@Entity
@Table(name="gama")
public class Gama implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGama;
    private String name;
    private String description;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="gama", orphanRemoval = true)
    @JsonIgnoreProperties("gama")
    private List<Car> cars = new ArrayList<Car>();
    
    public Gama(){
    }
    
    public Gama(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Gama(Long idGama, String name, String description) {
        this.idGama = idGama;
        this.name = name;
        this.description = description;
    }
            
    /**
     * @return the idGama
     */
    public Long getIdGama() {
        return idGama;
    }

    /**
     * @param idGama the idGama to set
     */
    public void setIdGama(Long idGama) {
        this.idGama = idGama;
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
     * @return the cars
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * @param cars the cars to set
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
}
