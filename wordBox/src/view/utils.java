
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;




public class utils {
    
    
     String getRandomWord() throws FileNotFoundException, IOException, ClassNotFoundException {
        
      readingFile file=new readingFile();  
      HashMap MAP =file.readList();
      
         
          
       
       Random generator= new Random();
       Object[] values=MAP.keySet().toArray();
       Object b=values[generator.nextInt(values.length)];
       String a=(String)b;
    
        
        
        return a;

    }
    
    
  String getAnswer(String english,String polskie) throws IOException, FileNotFoundException, ClassNotFoundException {
        
      String odpowiedz;
      readingFile file=new readingFile();  
      HashMap MAP =file.readList();
       
       
        System.out.println("wordsbox.logic.getOdpowiedz()uiouiouio" +english);
       
       String englishWord=(String) MAP.get(english);
        
       
       System.out.println("wordsbox.logic.getOdpowiedz()" +englishWord.toLowerCase());
  
 
     
       
       if(englishWord.equals(polskie)){
           odpowiedz = "dobrze";
         
           
       }else{
           odpowiedz = "nie dobrze";
         
       }
           return odpowiedz;
       
       
    }

       
    
      String saveList(String english,String polish) throws FileNotFoundException, IOException, ClassNotFoundException {

      readingFile file=new readingFile();  
      HashMap MAP =file.readList();
           
        FileOutputStream f = new FileOutputStream(new File("C:\\wordsApp\\wordBox"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        
        MAP.put(english, polish);
        o.writeObject(MAP);

        o.close();
        f.close();
        
        return "Dodano Słowo";

    }
      
     void saveList() throws FileNotFoundException, IOException, ClassNotFoundException {

      readingFile file=new readingFile();  
      HashMap MAP =file.readList();
           
        FileOutputStream f = new FileOutputStream(new File("C:\\wordsApp\\wordBox"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        
        MAP.clear();
        o.writeObject(MAP);

        o.close();
        f.close();
        
        

    }
      
      
     static void saveFirst() throws FileNotFoundException, IOException {

       Map<String, String> mapa = new HashMap<String, String>();
         
       File file = new File("C:\\wordsApp\\wordBox");
        
       if(!file.exists()){
           
           System.out.println("doddano plik C:\\wordsApp\\wordBox ");  
        FileOutputStream f = new FileOutputStream(new File("C:\\wordsApp\\wordBox"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        
        o.writeObject(mapa);

        o.close();
        f.close();
       }
    }
      

    
}
