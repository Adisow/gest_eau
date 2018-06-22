/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofacturation;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author masdev
 */
public class ConnectionControler {
    
      @FXML
    private TextField utulisateur;

    @FXML
    private Button connecte;

    @FXML
    private PasswordField password;
    @FXML
    private Label alertmessage;
    
   private Connection conn= null;
   private PreparedStatement pst = null;
   private  ResultSet rs= null; 
   Stage stage;
   Parent root;
   Scene scene;
   

    @FXML
     public void connectionAction(ActionEvent event)throws Exception {
        
          Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER OK ! ");
            
            //Connection à la base de donnée
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root");  
            pst = conn.prepareStatement("SELECT * FROM user WHERE login='"+utulisateur.getText()+"' AND password='"+password.getText()+"'");
          rs=pst.executeQuery();
          
        if(rs.next()){
            
        try{
            stage=(Stage) connecte.getScene().getWindow();
        FXMLLoader fxmlloader = new  FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent)fxmlloader.load();
        stage.setTitle("Inscription");
        stage.setScene(new Scene(root1));
        stage.show();
        } catch(Exception e){
            System.out.println("desole");
    }
        
            
           alertmessage.setText("Bienvene M. L'administrateur");
        }else{
              alertmessage.setText("Login ou mot de passe incorrecte");
       
        }

    }

    
}
