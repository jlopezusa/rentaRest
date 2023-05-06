/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Clgmses/Clgms.java to edit this template
 */
package com.example.demo;

import com.example.entity.Gama;
import com.example.servicios.GamaServices;
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
@RequestMapping("/api/Gama")
public class ControllerGama {
    
    @Autowired
    GamaServices gm;
    
    @GetMapping("/all")
    public ArrayList<Gama> getGamgm(){
        return gm.getGamasFromDB();
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
    public Gama insertData(@RequestBody Gama g){
        return gm.createGama(g);
    }
    
    @PutMapping("/update/{id}")
    public Gama updateData(@PathVariable("id") Long id,@RequestBody Gama g){
        Gama upg = gm.getGama(id);
        upg.setName(g.getName());
        upg.setDescription(g.getDescription());
        return gm.createGama(upg);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public Optional<Gama> getGama(@PathVariable("id") Long id){
        return gm.getGById(id);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public String deleteGama(Gama p, @PathVariable("id") Long id){
        boolean status = gm.deleteGama(id);
        if(status){
            return "Gama eliminada con exito";
        }else{
            return "No se puede eliminar Gama";
        }
    }
}
