/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @Karol Słoma
 */
public class readingFile {
   
     TableView table=  new TableView<>();
     public static final ObservableList names= FXCollections.observableArrayList();
    
  
   
    
      HashMap readList() throws FileNotFoundException, IOException, ClassNotFoundException {
      HashMap mapa = new HashMap();
       
          
            FileInputStream fi = new FileInputStream(new File("C:\\wordsApp\\wordBox"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            
            mapa=(HashMap)oi.readObject();
            
          
            
            
            fi.close();
            oi.close();
     

            return mapa;
            
            
            
            
            
    }
    
    
        ObservableList  getList(){
          
                try {
                    System.out.println(".handle()pppppppppppppppp");
                    
                    readingFile rf=new readingFile();
                    
                    HashMap a = rf.readList();
                    
                    
                         for (Object name : a.keySet()) {

                    String key = name.toString();
                
                    String value = a.get(name).toString();
                    
                    names.add(key+" : "+value);
                  
                    System.out.println(key + " " + value);
                    
                }
                         
                             
                    
                } catch (IOException ex) {
                    Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(wordBoxController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return names;
            }
            
}
     

