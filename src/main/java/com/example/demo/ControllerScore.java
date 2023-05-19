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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score insertData(@RequestBody Score s){
        return sc.createScore(s);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score updateData(@RequestBody Score s){
        if(s.getIdScore()!= null){
            Score ups = sc.getScore(s.getIdScore());
            if(ups != null){
                ups.setScore(s.getScore());
                if(s.getMessage() != null){
                    ups.setMessage(s.getMessage());
                }
                if(s.getReservation() != null){
                    ups.setReservation(s.getReservation());
                }
                return sc.createScore(ups);
            }else{
                return s;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    public Optional<Score> getScore(@PathVariable("id") Long id){
        return sc.getSById(id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteScore(Score p, @PathVariable("id") Long id){
        boolean status = false;
        if(sc.getScore(id) != null){
            status = sc.deleteScore(id);
        }
        return status;
    }
}
