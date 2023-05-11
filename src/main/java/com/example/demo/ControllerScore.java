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
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Score")
public class ControllerScore {
    
    @Autowired
    ScoreServices sc;
    
    @GetMapping("/all")
    public ArrayList<Score> getScores(){
        return sc.getScoresFromDB();
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/all")
    public Score insertData(@RequestBody Score s){
        return sc.createScore(s);
    }
    
    @PutMapping("/update/{id}")
    public Score updateData(@PathVariable("id") Long id,@RequestBody Score s){
        Score ups = sc.getScore(id);
        ups.setScore(s.getScore());
        ups.setMessage(s.getMessage());
        ups.setReservation(s.getReservation());
        return sc.createScore(ups);
    }
    
    @GetMapping("/get/{id}")
    public Optional<Score> getScore(@PathVariable("id") Long id){
        return sc.getSById(id);
    }
    
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
