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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Javis
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Gama")
public class ControllerGama {
    
    @Autowired
    GamaServices gm;
    
    @GetMapping("/all")
    public ArrayList<Gama> getGama(){
        return gm.getGamasFromDB();
    }
    
    @GetMapping("/text")
    public String getText(){
        return "Hello World";
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama insertData(@RequestBody Gama g){
        return gm.createGama(g);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama updateData(@RequestBody Gama g){ 
        if(g.getIdGama()!= null){
            Gama upg = gm.getGama(g.getIdGama());
            if(upg != null){
                if(g.getName() != null){
                    upg.setName(g.getName());
                }
                if(g.getDescription() != null){
                    upg.setDescription(g.getDescription());
                }
                return gm.createGama(upg);
            }else{
                return g;
            }
        }else{
            return null;
        }
    }
    
    @GetMapping("/get/{id}")
    public Optional<Gama> getGama(@PathVariable("id") Long id){
        return gm.getGById(id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteGama(Gama p, @PathVariable("id") Long id){
        boolean status = false;
        if(gm.getGama(id) != null){
            status = gm.deleteGama(id);
        }
        return status;
    }
}
