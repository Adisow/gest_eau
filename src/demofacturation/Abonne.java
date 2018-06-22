/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofacturation;

import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;

/**
 *
 * @author masdev
 */
public class Abonne {
    
    private String  nom;
    private String prenom;
    private String  adresse;
    private Double telephone;
    private Double numCompte;
    private Date dateNaissance;
    private Button bouton;
    
 public Abonne(String nom, String prenom, String adresse, Double telephone, Double numCompte, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.numCompte = numCompte;
        this.dateNaissance = dateNaissance;
        this.bouton = new Button("Editer");
    }
 
 public Abonne() {
       
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Double getTelephone() {
        return telephone;
    }

    public Double getNumCompte() {
        return numCompte;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
     public Button getBouton() {
        return bouton;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(Double telephone) {
        this.telephone = telephone;
    }

    public void setNumCompte(Double numCompte) {
        this.numCompte = numCompte;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
 
     public void setDateNaissance(Button bouton) {
        this.bouton = bouton;  
    }
 
    
    
   
}
