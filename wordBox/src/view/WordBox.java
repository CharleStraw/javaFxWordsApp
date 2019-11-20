package view;



import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WordBox extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        final String appName="WordsBox";
    
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/wordBoxLeyout.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle(appName);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
      
        launch(args);
      
    }
    
}