/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.servicios;

import com.example.repository.IClientDao;
import com.example.entity.Client;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javis
 */
@Service
public class ClientServices {
    
    @Autowired
    IClientDao clientDao;
    
    public ArrayList<Client> getClientsFromDB(){
        return (ArrayList<Client>)clientDao.findAll();
    }
    
    public Client createClient(Client c){
        return clientDao.save(c);
    }
    
    public Optional<Client> getClById(Long id){
        return clientDao.findById(id);
    }
    
    public Client getClient(Long id){
        return clientDao.findById(id).orElse(null);
    }
    
    public boolean deleteClient(Long id){
        try{
            clientDao.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
