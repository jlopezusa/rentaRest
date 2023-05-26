/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.repository.IGamaDao;
import com.example.repository.ICarDao;
import com.example.repository.IClientDao;
import com.example.repository.IReservationDao;
import com.example.entity.Gama;
import com.example.entity.Client;
import com.example.entity.Car;
import com.example.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Javis
 */
@Controller
public class ControllerFront {
    
    @Autowired
    IGamaDao gamaDao;
    @Autowired
    IClientDao clientDao;
    @Autowired
    ICarDao carDao;
    @Autowired
    IReservationDao reservationDao;
    
    @GetMapping(value="/front")
    public String índex(){
        return "index";
    }
    
    @GetMapping(value="/home")
    public String home(){
        return "home";
    }
    
    @GetMapping(value="/carros")
    public String cars(Model m){
        Iterable<Gama> gamas = gamaDao.findAll();
        m.addAttribute("gamas", gamas);
        return "/modules/carros";
    }
    
    @GetMapping(value="/gamas")
    public String gamas(Model m){
        m.addAttribute("title", "Gama");
        return "/modules/gamas";
    }
    
    @GetMapping(value="/calificaciones")
    public String scores(Model m){
        Iterable<Reservation> reservaciones = reservationDao.findAll();
        m.addAttribute("reservaciones", reservaciones);
        return "/modules/score";
    }
    
    @GetMapping(value="/reservaciones")
    public String reservations(Model m){
        Iterable<Client> clientes = clientDao.findAll();
        Iterable<Car> carros = carDao.findAll();
        m.addAttribute("clientes", clientes);
        m.addAttribute("carros", carros);
        return "/modules/reservaciones";
    }
    
    @GetMapping(value="/mensajes")
    public String messages(Model m){
        Iterable<Client> clientes = clientDao.findAll();
        Iterable<Car> carros = carDao.findAll();
        m.addAttribute("clientes", clientes);
        m.addAttribute("carros", carros);
        return "/modules/mensajes";
    }
    
    @GetMapping(value="/clientes")
    public String clients(){
        return "/modules/clientes";
    }
    
    @GetMapping(value="/administradores")
    public String admins(){
        return "/modules/administradores";
    }
    
    @GetMapping(value="/error")
    public ModelAndView error(){
        return new ModelAndView("error", HttpStatus.NOT_FOUND); 
    }
}
