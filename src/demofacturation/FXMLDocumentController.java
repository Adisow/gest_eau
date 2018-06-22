/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofacturation;
import connectivity.ConnectionClass;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author masdev
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField nom;
 
    @FXML
    private TextField prenom;
    
    @FXML
    private TextField ville;
    @FXML
    private TextField num;
    
    @FXML
    private TextField tele;

      @FXML
    private TextArea  textadd;
      
       @FXML
    private TextField nomrecheche;
 
      @FXML
    private DatePicker date;
         
      @FXML
    private TableView<Abonne> taable;
    @FXML
    private TableColumn<Abonne, String>  nomtab;
      @FXML
    private TableColumn<Abonne, String> prenomtab;
      @FXML
    private TableColumn<Abonne, Integer>  Telephonetab;
      @FXML
    private TableColumn<Abonne, Integer>  numcompttab;
       @FXML
    private TableColumn<Abonne, String> villetab;
       
         @FXML
    private TableColumn<Abonne, String> edittable;
       
            @FXML
    private AnchorPane AnchorPane;
                    
            @FXML
    private Pane contentarea;
                   
   @FXML  ListView<String> listview1; 
   private Connection conn= null;
   private PreparedStatement pst = null;
   private  ResultSet rs= null; 
   private ObservableList<Abonne> data ;
    private Node[] fxml;
    @FXML
    private Button modif;
    
    @FXML
    private Button deconnecte;

    
   Stage stage;
   Parent root;
   Scene scene;
    @FXML
    private Pane ajoutdate;

    @FXML
    private TextField ajoutnom;

    @FXML
    private TextField ajoutprenom;

    @FXML
    private TextField ajouttel;

    @FXML
    private TextField ajoutnumer;

    @FXML
    private Button insert;

    @FXML
    private Button reset;

    @FXML
    void ajoterAction(ActionEvent event) {

    }

    @FXML
    void annulerAction(ActionEvent event) {

    }

    @FXML
    void controletel(KeyEvent event) {

    }
   
   
 
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void TesteInsertAction(ActionEvent event) throws SQLException, ClassNotFoundException {
           System.out.println("You clicked me!");
                                      Class.forName("com.mysql.jdbc.Driver");
					System.out.println("DRIVER OK ! ");

					//Connection à la base de donnée 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root");
					System.out.println("Connection effective !");			
 
					Statement state = conn.createStatement();
					String requete="Select * From abonne";
					state.executeUpdate(requete);
 
 
    }
    
    public void ajouterAction(ActionEvent event) throws SQLException, ClassNotFoundException{

    textadd.setText(nom.getText()+'-'+prenom.getText()+'-'+ville.getText()+'-'+num.getText()+'-'+tele.getText());
    listview1.getItems().add(nom.getText()+' '+' '+' '+prenom.getText()+' '+' '+' '+ville.getText()+' '+' '+' '+num.getText()+' '+tele.getText());
  
                                       Class.forName("com.mysql.jdbc.Driver");
					System.out.println("DRIVER OK ! ");

					//Connection à la base de donnée 
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root");
					System.out.println("Connection effective !");			
 
					Statement state = conn.createStatement();
					String requete="INSERT INTO abonne(nom, prenom, adresse, telephone, num_compte, date_naissance) VALUES('"+nom.getText()+"', '"+prenom.getText()+"', '"+ville.getText()+"', '"+num.getText()+"', '"+tele.getText()+"', '2018-05-30')";
					state.executeUpdate(requete);
 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data =FXCollections.observableArrayList();
       
        
        try {
            nomtab.setCellValueFactory(new PropertyValueFactory<Abonne, String> ("nom"));
            prenomtab.setCellValueFactory(new PropertyValueFactory<Abonne, String> ("prenom"));
            Telephonetab.setCellValueFactory(new PropertyValueFactory<Abonne, Integer> ("telephone"));
            numcompttab.setCellValueFactory(new PropertyValueFactory<Abonne, Integer> ("numCompte"));
            villetab.setCellValueFactory(new PropertyValueFactory<Abonne, String> ("adresse"));
            edittable.setCellValueFactory(new PropertyValueFactory<Abonne, String> (""));        
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER OK ! ");
            
            //Connection à la base de donnée
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root"); 
            
            pst = conn.prepareStatement("select * from abonne");
            rs =pst.executeQuery();
            while(rs.next()){
            data.add(new Abonne(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7)));
            }
            
                    
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        taable.setItems(data);
       
    }   
     
    public void rechercheAction(ActionEvent event){
        
     
         data =FXCollections.observableArrayList();
        
        try {
            nomtab.setCellValueFactory(new PropertyValueFactory<Abonne, String> ("nom"));
            prenomtab.setCellValueFactory(new PropertyValueFactory<Abonne, String> ("prenom"));
            Telephonetab.setCellValueFactory(new PropertyValueFactory<Abonne, Integer> ("telephone"));
            numcompttab.setCellValueFactory(new PropertyValueFactory<Abonne, Integer> ("numCompte"));
            villetab.setCellValueFactory(new PropertyValueFactory<Abonne, String> ("adresse"));
              
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER OK ! ");
            
            //Connection à la base de donnée
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/forage","root", "root");  
            pst = conn.prepareStatement("select * from abonne where nom Like '%"+nomrecheche.getText()+"%'");
            rs =pst.executeQuery();
            while(rs.next()){
            data.add(new Abonne(rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDate(7)));
            }
                
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        taable.setItems(data);
        
    }
     
    public void facturerAction(ActionEvent event) throws IOException{ 
      Parent root;
        try {
            FXMLLoader.load(getClass().getResource("FXMLFacturation.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       AnchorPane.getClass();
    }
    
    public void AnnulerAction(ActionEvent event){
      nom.setText(null);
      prenom.setText(null);
      ville.setText(null);
      num.setText(null);
      tele.setText(null);
  
    }
  
    public void setCellTable(){
       
    }
    
    public void NewFormulaireAcion(ActionEvent event){  
    
        try{
        FXMLLoader fxmlloader = new  FXMLLoader(getClass().getResource("Inscription.fxml"));
        Parent root1 = (Parent)fxmlloader.load();
        Stage stage =new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Inscription");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.showAndWait();
        } catch(Exception e){
            System.out.println("desole");
    }
        
    }
    
    @FXML
   public void modfierElet(ActionEvent event) { 
     taable.removeEventHandler(EventType.ROOT, null); taable.getRowFactory();
    }
    
      @FXML
    public void deconnexion(ActionEvent event) {
 try{
            stage=(Stage) deconnecte.getScene().getWindow();
        FXMLLoader fxmlloader = new  FXMLLoader(getClass().getResource("Connection.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        Parent root1 = (Parent)fxmlloader.load();
        stage.setTitle("Login");
        stage.setScene(new Scene(root1, 1200,900));
        stage.show();
        } catch(Exception e){
            System.out.println("desole");
    }
 
    }
    
    
     @FXML
   public void testeformulaireAction(ActionEvent event) {
TextInputDialog  inDialog= new TextInputDialog("Nom");
TextInputDialog  prenom= new TextInputDialog("Nom");
inDialog.setTitle("Nouveau Abonne");
inDialog.setHeaderText("Account Login (or Guest Access)");
inDialog.setContentText("Nom:");
Optional<String> textIn= inDialog.showAndWait();
if(textIn.isPresent())
{
System.out.println
("Login name= "+ textIn.get());}

    }

}
