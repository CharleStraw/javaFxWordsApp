package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static view.utils.saveFirst;
public class wordBoxController implements Initializable{

     @FXML
    private AnchorPane AnchorPanelId;

    @FXML
    private Button wordsList;

    @FXML
    private ListView<?> listVievId;

    @FXML
    private Label englishWordId;

    @FXML
    private Button wylosujSlowoId;
    
    @FXML
    private Button sprawdzId;
  
    @FXML
    private TextField odpowiedzId;
     
    @FXML
    private TextField addEnglishId;

    @FXML
    private TextField addPolishId;

    @FXML
    private Button addWordId;
   
    
    @FXML
    private Label lableAddId;
    
    
    @FXML
    private Button deleteListId;

    
     String randomWord ;
     String answer;
     String polishWord;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        
        
        
             deleteListId.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event){
                     
                 
                     utils ut =new utils();
                     try {
                         listVievId.getItems().clear();
                         ut.saveList();
                     } catch (IOException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     
                 }
             });
             
             
             
             
             
             addWordId.setOnAction(new EventHandler<ActionEvent>(){
                 
                 utils ut =new utils();
                 
                 @Override
                 public void handle(ActionEvent event){
                     
                     
                     
                   
                         String add = null;
                     try {
                         add = ut.saveList(addEnglishId.getText().toLowerCase(),addPolishId.getText().toLowerCase());
                     } catch (IOException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                         lableAddId.setText(add);
                         addEnglishId.clear();
                         addPolishId.clear();
                  
                     
                     
                     
                 }
             });
             
             
             
             wordsList.setOnAction(new EventHandler<ActionEvent>() {
              
                 
               
           
                 @Override
                 public void handle(ActionEvent event) {
                     try {
                         saveFirst();
                         listVievId.getItems().clear();
                         readingFile file =  new readingFile();
                         
                         
                         ObservableList MAP = file.getList();
                         
                         listVievId.setItems(MAP);
                     } catch (IOException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     }
             }});
             
             
             wylosujSlowoId.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event) {
                     try {
                         utils ut =new utils();
                         randomWord = ut.getRandomWord();
                         englishWordId.setText(randomWord);
                     } catch (IOException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     
                 }
                 
                 
                 
                 
             });
             
             
             sprawdzId.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event) {
                     
                     polishWord = odpowiedzId.getText();
                     utils ut =new utils();
                     try {
                         answer = ut.getAnswer(randomWord,polishWord.toLowerCase());
                         odpowiedzId.clear();
                     } catch (IOException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     englishWordId.setText(answer);
                     
                 }
                 
                 
                 
                 
             });
     
        
    
           
              
           

    
    }
    
}
