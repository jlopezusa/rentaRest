/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.repository.IScoreDao;
import com.example.entity.Score;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javis
 */
@Service
public class ScoreServices {
    
    @Autowired
    IScoreDao scoreDao;
    
    public ArrayList<Score> getScoresFromDB(){
        return (ArrayList<Score>)scoreDao.findAll();
    }
    
    public Score createScore(Score s){
        return scoreDao.save(s);
    }
    
    public Optional<Score> getSById(Long id){
        return scoreDao.findById(id);
    }
    
    public Score getScore(Long id){
        return scoreDao.findById(id).orElse(null);
    }
    
    public boolean deleteScore(Long id){
        try{
            scoreDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
