package ru.javabegin.training.web.controllers;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author nik
 */
@ManagedBean
@RequestScoped
public class LoginController {

   
    public LoginController() {
    }
    
    
    public String login(){
        
        return "books";
    }
    
    
}
