package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String[] args)
	{
		launch(args);

	}
	public void start(Stage primaryStage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
		Scene newscene=new Scene(root);
		primaryStage.setScene(newscene);
		primaryStage.show();
	}

}
