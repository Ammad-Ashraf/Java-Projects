package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;


public class Main extends Application 
{
	GridPane layout1=new GridPane();
	Text name=new Text("Student Registration Form");
	TextField firstName=new TextField();
	TextField lastName=new TextField();
	DatePicker date=new DatePicker();
	ToggleGroup toggle = new ToggleGroup();
	RadioButton bt1 = new RadioButton("Male");
	RadioButton bt2 = new RadioButton("Female");
	RadioButton bt3 = new RadioButton("Other");
	TextField email=new TextField();
	TextField phone=new TextField();
	TextField address=new TextField();
	TextField address1=new TextField();
	ComboBox subjects = new ComboBox();
	Button btn1=new Button("Submit");
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			
			// Form Name 
			name.setFill(Color.BLUEVIOLET);
			name.setFont(Font.font("Verdana",FontWeight.NORMAL, 30));
			
			// Full Name 
			Label lbl = new Label("First Name");
			lbl.setTextFill(Color.BLACK);
			lbl.setFont(Font.font("Verdana", 15));
			
			Label lb2 = new Label("Last Name");
			lb2.setTextFill(Color.BLACK);
			lb2.setFont(Font.font("Verdana", 15));
			
			firstName.setPrefWidth(160);
			firstName.setPrefHeight(40);
			lastName.setPrefWidth(160);
			lastName.setPrefHeight(40);
			firstName.setStyle("-fx-background-radius: 10; -fx-border-radius: 8; -fx-border-color: #909090;");
			lastName.setStyle("-fx-background-radius: 10; -fx-border-radius: 8; -fx-border-color: #909090;");
			
			// Date of birth ( Combo-boxes OR Date Picker)
			
			date.setStyle("-fx-pref-width: 160px; -fx-pref-height: 40px;-fx-border-radius: 8; -fx-border-color: #909090;");
			date.setPromptText("Your Date of Birth");
			Label lb3 = new Label("Select Date of Birth");
			lb3.setTextFill(Color.BLACK);
			lb3.setFont(Font.font("Verdana", 16));
			
			// Gender
			Label lb4 = new Label("Select your gender");
			lb4.setTextFill(Color.BLACK);
			lb4.setFont(Font.font("Verdana", 16));
			bt1.setFont(Font.font("Verdana", 13));
			bt2.setFont(Font.font("Verdana", 13));
			bt3.setFont(Font.font("Verdana", 13));
			
			bt1.setToggleGroup(toggle);
			bt2.setToggleGroup(toggle);
			bt3.setToggleGroup(toggle);
			
			// Email Address
			Label lb5 = new Label("Enter your Email Address");
			lb5.setTextFill(Color.BLACK);
			lb5.setFont(Font.font("Verdana", 16));
			email.setPrefWidth(220);
			email.setPrefHeight(40);
			email.setStyle("-fx-background-radius: 10; -fx-border-radius: 8; -fx-border-color: #909090;");
			
			// Contact Number
			Label lb6 = new Label("Enter your Contact Info");
			lb6.setTextFill(Color.BLACK);
			lb6.setFont(Font.font("Verdana", 16));
			phone.setPrefWidth(220);
			phone.setPrefHeight(40);
			phone.setStyle("-fx-background-radius: 10; -fx-border-radius: 8; -fx-border-color: #909090;");
			
			//Address Info
			Label lb7 = new Label("Address");
			lb7.setTextFill(Color.BLACK);
			lb7.setFont(Font.font("Verdana", 17));
			address.setPrefWidth(220);
			address.setPrefHeight(40);
			address.setStyle("-fx-background-radius: 10; -fx-border-radius: 8; -fx-border-color: #909090;");
			Label lb8 = new Label("*");
			lb8.setTextFill(Color.RED);
			lb8.setFont(Font.font("Verdana", 18));
			address1.setPrefWidth(220);
			address1.setPrefHeight(40);
			address1.setStyle("-fx-background-radius: 10; -fx-border-radius: 8; -fx-border-color: #909090;");
			
			// Courses
			subjects.getItems().add("English");
			subjects.getItems().add("DSA");
			subjects.getItems().add("OOP");
			subjects.getItems().add("SDA");
			subjects.setStyle("-fx-pref-width: 160px; -fx-pref-height: 40px;-fx-border-radius: 8; -fx-border-color: #909090;");
			subjects.setPromptText("Choose Courses");
			Label lb9 = new Label("Select Courses");
			lb9.setTextFill(Color.BLACK);
			lb9.setFont(Font.font("Verdana", 16));
			
			// Buttons
			btn1.setTextFill(Color.WHITE);
			btn1.setFont(Font.font("Verdana", 18));
			btn1.setStyle("-fx-pref-width: 290px; -fx-pref-height: 40px;-fx-border-radius: 20; -fx-background-color: BLUEVIOLET;"
					+ "-fx-border-radius: 20; -fx-background-radius: 20;");
			
			// Menu Bar
			MenuBar main_menu = new MenuBar();
			Menu menuFile=new Menu("Menu");
			Menu clear = new Menu("Clear Form");
			Menu exit = new Menu("Exit");
			clear.setOnAction(e->clearForm());
			exit.setOnAction(e->Platform.exit());
			menuFile.getItems().addAll(clear,exit);
			main_menu.getMenus().addAll(menuFile);
			main_menu.setStyle("-fx-pref-width: 200px; -fx-pref-height: 30px;-fx-background-color: WHITE;"
					+ "-fx-border-radius: 10; -fx-background-radius: 10;-fx-font-family: 'Verdana';-fx-font-weight:bold;");
			
			
			//Add form name
			layout1.add(name, 15, 3);
			//Add full name
			HBox labels=new HBox(110);
			labels.getChildren().addAll(lbl,lb2);
			
			HBox fullname = new HBox(35);
			fullname.getChildren().addAll(firstName, lastName);
			
			layout1.add(labels, 15, 6); 
			layout1.add(fullname, 15, 7);
			//Add date picker
			HBox dob=new HBox(37);
			dob.getChildren().addAll(lb3,date);
			layout1.add(dob, 15, 10);
			//Add Gender
			HBox genders=new HBox(18);
			genders.getChildren().addAll(lb4,bt1,bt2,bt3);
			layout1.add(genders,15,13);
			// Add email address
			layout1.add(lb5, 15, 15);
			layout1.add(email, 15, 16);
			//Add contact info
			layout1.add(lb6, 15, 19);
			layout1.add(phone, 15, 20);
			// Add Address
			layout1.add(lb7,15,22);
			layout1.add(address, 15, 23);
			layout1.add(lb8,15,24);
			layout1.add(address1, 15, 25);
			// Add Courses
			VBox courses=new VBox();
			courses.getChildren().add(subjects);
			HBox last=new HBox(40);
			last.getChildren().addAll(lb9,courses);
			layout1.add(last, 15,27 );
			// Add button
			layout1.add(btn1, 15, 30);
			GridPane.setMargin(btn1, new Insets(10, 0, 0, 50));
			//Add menu bar
			layout1.add(main_menu, 15, 5);
			
			layout1.setHgap(35);
			layout1.setVgap(10);
			
			// Add layout in Scene
			Scene scene1=new Scene(layout1);
			
			// Add scene in Stage
			primaryStage.setScene(scene1);
			primaryStage.setTitle("Student Registration Form");
			primaryStage.setFullScreen(true);
			primaryStage.show();
			
			 btn1.setOnAction(new EventHandler<ActionEvent>()
			{
				 @Override
				public void handle(ActionEvent event) 
				 {
					 String validationResult = validateForm();
					    if (!validationResult.isEmpty())
					    {
					        showAlert(Alert.AlertType.ERROR, "Validation Error", validationResult);
					    } 
					    else
					    {
					        showAlert(Alert.AlertType.INFORMATION, "Success", "Form is valid!");
					        
					    }		
				 }	 
			});
			 
				
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void clearForm()
	{
		firstName.clear();
		lastName.clear();
	    date.setValue(null);
	    email.clear();
	    phone.clear();
	    address.clear();
	    toggle.selectToggle(null);
	    subjects.setValue(null); 
	}
	private void showAlert(Alert.AlertType alertType, String title, String content) 
	{
	    Alert alert = new Alert(alertType);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(content);
	    alert.showAndWait();
	}
	private String validateForm()
	{
		if(firstName.getText().trim().isEmpty()||lastName.getText().trim().isEmpty())
		{
			return "Full Name should not be empty.";
		}
	    if (date.getValue() == null) 
	    {
	        return "Date of Birth should be selected.";
	    }
	    if(toggle.getSelectedToggle()==null)
	    {
	    	return "Gender should be selected.";
	    }
	    if (email.getText().trim().isEmpty())
	    {
	        return "Email Address should not be empty.";
	    }
	    if (phone.getText().trim().isEmpty()) 
	    {
	        return "Contact Number should not be empty.";
	    }
	    if (address.getText().trim().isEmpty() && address1.getText().trim().isEmpty())
	    {
	        return "Address should not be empty.";
	    }
	    if (subjects.getValue()==null)
	    {
	        return "At least one course should be selected.";
	    }
	    return ""; 
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
