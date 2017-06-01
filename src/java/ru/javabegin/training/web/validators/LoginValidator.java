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

/**
 *
 * @author nik
 */
@FacesValidator("ru.javabegin.training.web.validators.LoginValidator")
public class LoginValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
        if (value.toString().length() < 5){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages",FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("login_length_error"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
        
        
    }
    
}
