/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofacturation;

import java.util.logging.Logger;

/**
 *
 * @author masdev
 */
public class User {
    
    private int id;
    private String login;
    private String password;
    private String nom;
    private String prenom;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public User(){
        
    }

    public User(String login, String password, String nom, String prenom) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }
   
    
    
}
