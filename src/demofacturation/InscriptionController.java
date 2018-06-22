/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofacturation;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * FXML Controller class
 *
 * @author masdev
 */
public class InscriptionController implements Initializable {
    @FXML
    private TextField newnom;
    @FXML
    private TextField newprenom;
    @FXML
    private TextField newadresse;
    @FXML
    private TextField newtelephone;
    @FXML
    private TextField newcompt;
    @FXML
    private DatePicker naisssancedate;
    @FXML
    private Button newmember;
    @FXML
    private Button setnull;
    @FXML
    private ListView voirlist;
    
    @FXML
    private Text testecontrol;
    
    @FXML
    private Text prenomcontrol;
      
    @FXML
    private Text controltele;
    @FXML
    private Text controladresse;   
       
    @FXML
    private Text controlnumc;
    @FXML
    private Text controldate;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        newtelephone.textProperty().addListener((observable, oldValue, newValue) -> {
    if(!newValue.matches("[0-9]*")){
        newtelephone.setText(oldValue);
    }
});
        
          newcompt.textProperty().addListener((observable, oldValue, newValue) -> {
    if(!newValue.matches("[0-9]*")){
        newcompt.setText(oldValue);
    }
});
        // TODO
    }   
     
    @FXML
    private void newMemberaction(ActionEvent event) throws SQLException, ClassNotFoundException, ParseException {


       if(newnom.getText()!=null && newprenom.getText()!=null && newadresse.getText()!=null && newtelephone.getText()!=null && newcompt.getText()!=null&& naisssancedate.getValue()!=null){
            voirlist.getItems().add(newnom.getText()+' '+' '+' '+newprenom.getText()+' '+' '+' '+newadresse.getText()+' '+' '+' '+newtelephone.getText()+' '+newcompt.getText()+' '+naisssancedate.getValue());
        Class.forName("com.mysql.jdbc.Driver");
					System.out.println("DRIVER OK ! ");
					//Connection à la base de donnée 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root");
					System.out.println("Connection effective !");			
					Statement state = conn.createStatement();
					String requete="INSERT INTO abonne(nom, prenom, adresse, telephone, num_compte, date_naissance) VALUES('"+newnom.getText()+"', '"+newprenom.getText()+"', '"+newadresse.getText()+"', '"+newtelephone.getText()+"', '"+newcompt.getText()+"', '"+naisssancedate.getValue()+"')";
					state.executeUpdate(requete);
       }
       else{
        testecontrol.setText("Veuiilez saisir le nom");
        prenomcontrol.setText("Veullez saisir le prenom");
        controltele.setText("Veuillez saisir le telephone");
        controladresse.setText("Veuillez saisir adresse");
        controlnumc.setText("Veuillez saissir le numero");
        controldate.setText("Veuillez saisir la date");
}
       
    }
    
  @FXML
    public void teleNumber(KeyEvent event) {
        char c =event.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
        event.consume();
        
        }

    }
    @FXML
    private void setNullAction(ActionEvent event) {
        
      newnom.setText(null);
      newprenom.setText(null);
      newadresse.setText(null);
      newtelephone.setText(null);
      newcompt.setText(null);
      naisssancedate.setValue(null);   
      testecontrol.setText(null);
      prenomcontrol.setText(null);
      controltele.setText(null);
      controladresse.setText(null);
      controlnumc.setText(null);
      controldate.setText(null);
      
       try{
        FXMLLoader fxmlloader = new  FXMLLoader(getClass().getResource("Inscription.fxml"));
        Parent root1 = (Parent)fxmlloader.load();
        Stage stage =new Stage();
        stage.setTitle("Inscription");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.close();
        } catch(Exception e){
            System.out.println("desole");
    }  
       
    }
    
     @FXML
   public  void telephonekeyType(KeyEvent event) {
   char c =event.getKeyChar();
  if(!(Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE) ||c==KeyEvent.VK_DELETE){
      event.consume();
  }
    }
    
}
