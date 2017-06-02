/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.web.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import ru.javabegin.training.web.enums.SearchType;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author nik
 */
@ManagedBean
@SessionScoped
public class SearchController implements Serializable {
    
    private SearchType searchType;
    private static Map<String, SearchType> searchList = new HashMap<String, SearchType>();
    
    public SearchController() {
       ResourceBundle resourceBundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale()); 
       searchList.put(resourceBundle.getString("author_name"), SearchType.AUTHOR);
       searchList.put(resourceBundle.getString("book_name"), SearchType.TITLE);
    }
    
    public SearchType getSearchType() {
        return searchType;
    }
    
    public Map<String, SearchType> getSearchList() {
        return searchList;
    }
    
}
