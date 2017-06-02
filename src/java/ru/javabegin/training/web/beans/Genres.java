/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.web.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import ru.javabegin.training.web.db.Database;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author nik
 */


@ManagedBean
@ApplicationScoped
public class Genres implements Serializable {
    
    private ArrayList<Genre> genreList = new ArrayList<Genre>();
    
    private ArrayList<Genre> getGenres() {
        
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from library.genre order by name");
            
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genre.setId(rs.getLong("id"));
                genreList.add(genre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
        return genreList;
    }
    
    public ArrayList<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }
    
}
