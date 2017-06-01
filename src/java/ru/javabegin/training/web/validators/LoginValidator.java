/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.web.validators;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;

/**
 *
 * @author nik
 */
@FacesValidator("ru.javabegin.training.web.validators.LoginValidator")
public class LoginValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages",FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
        try {
            String newValue = value.toString();
            
            if (newValue.length() < 5) {
                throw new IllegalArgumentException(resourceBundle.getString("login_length_error"));
            }    
            
            if (!Character.isLetter(newValue.charAt(0))) {
                throw new IllegalArgumentException(resourceBundle.getString("first_letter_error"));
            }
               
            if (getTestArray().contains(newValue)) {
                throw new IllegalArgumentException(resourceBundle.getString("used_name"));
            }
        
       
        } catch(IllegalArgumentException e) {
            FacesMessage facesMessage = new FacesMessage(e.getMessage());
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
          }
    }
        
    private ArrayList<String> getTestArray(){
    
      ArrayList<String> list = new ArrayList<String>();
      list.add("username");   
      list.add("login");
      return list;
    }
        
}

    
    

