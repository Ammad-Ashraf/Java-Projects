package application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryManagement extends Application 
{

    

    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	
    	
        Parent root =FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Library Management System");
        primaryStage.show();

        
    }

   

    public static void main(String[] args)
    {
        launch(args);
    }
}

