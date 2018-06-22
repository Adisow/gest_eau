/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofacturation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author masdev
 */
public class DemoFacturation extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Connection.fxml"));
        VBox vbox =new VBox();
        vbox.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 1200,900);
        stage.setResizable(true);
        stage.setTitle("Gestion Forage");
        stage.setScene(scene);
        stage.show();
    }
    
     public void NewFormulaireAcion(ActionEvent event){  
        try{
        FXMLLoader fxmlloader = new  FXMLLoader(getClass().getResource("Inscription.fxml"));
        Parent root1 = (Parent)fxmlloader.load();
        Stage stage =new Stage();
        stage.setTitle("Inscription");
        stage.setScene(new Scene(root1));
        stage.show();
        } catch(Exception e){
            System.out.println("desole");
    }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
