/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Javis
 */
@Entity
@Table(name="reservation")
public class Reservation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="devolution_date")
    private Date devolutionDate;
    //@Column(columnDefinition="default 'created'")
    private String status;
    /*@CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date dateCreated;*/
    
    @ManyToOne()
    @JoinColumn(name = "carId")
    @JsonIgnoreProperties("reservations")
    private Car car;
    
    @ManyToOne()
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("reservation")
    private Score score;
    /**
     * @return the id
     */
    public Reservation(){
    }
    
    public Reservation(Long idReservation, Date startDate, Date devolutionDate, String status, Car car, Client client, Score score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.car = car;
        this.client = client;
        this.score = score;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    /**
     * @param id the id to set
     */
    public void setIdReservation(Long id) {
        this.idReservation = id;
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
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the score
     */
    public Score getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Score score) {
        this.score = score;
    }
}
