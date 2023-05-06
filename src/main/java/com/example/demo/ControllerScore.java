/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clscses/Clscs.java to edit this template
 */
package com.example.demo;

import com.example.entity.Score;
import com.example.servicios.ScoreServices;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author Javis
 */
@RestController
@RequestMapping("/api/Score")
public class ControllerScore {
    
    @Autowired
    ScoreServices sc;
    
    @GetMapping("/all")
    public ArrayList<Score> getScores(){
        return sc.getScoresFromDB();
    }
    
    /*public ResponseEntity<List> getPeople(){
        ArrayList al = ps.getPeopleFromDB();
        return ResponseEntity.ok(al);
    }*/
    
    //@CrossOrigin(origins = "*")
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    public Score insertData(@RequestBody Score s){
        return sc.createScore(s);
    }
    
    @PutMapping("/update/{id}")
    public Score updateData(@PathVariable("id") Long id,@RequestBody Score s){
        Score ups = sc.getScore(id);
        ups.setScore(s.getScore());
        ups.setMessage(s.getMessage());
        ups.setReservationId(s.getReservationId());
        return sc.createScore(ups);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public Optional<Score> getScore(@PathVariable("id") Long id){
        return sc.getSById(id);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public String deleteScore(Score p, @PathVariable("id") Long id){
        boolean status = sc.deleteScore(id);
        if(status){
            return "Score eliminado con exito";
        }else{
            return "No se puede eliminar score";
        }
    }
}
