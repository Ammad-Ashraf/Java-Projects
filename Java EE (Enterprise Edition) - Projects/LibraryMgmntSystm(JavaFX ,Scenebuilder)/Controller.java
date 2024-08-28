package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Platform;
public class Controller
{
	@FXML
    private MenuBar menuBar; 

    @FXML
    private TableView<Book> bookTable; 

    @FXML
    private TextField titlefield;

    @FXML
    private TextField authorfield;

    @FXML
    private TextField isbnfield;

    @FXML
    private TextField statusfield; 
    
    @FXML
    private TableColumn<Book, String> titleColumn, authorColumn, isbnColumn, availabilityColumn;

    private ObservableList<Book> booksData = FXCollections.observableArrayList();

    public void handleMenuItemAction(ActionEvent event)
    {
        MenuItem source = (MenuItem) event.getSource();
        switch (source.getId()) 
        { 
            case "menuNew":
                
            	showNewBookDialog();
                break;
            case "menuOpen":
                
                loadBooksFromFile();
                break;
            case "menuSave":
                
                saveBooksToFile();
                break;
            case "menuSaveAs":
               
                saveBooksToFileAs();
                break;
            case "menuExit":
                System.exit(0);
                break;
            case "menuAddBook":
                showNewBookDialog();
                break;
            case "menuEditBook":
                editSelectedBook();
                break;
            case "menuDeleteBook":
                deleteSelectedBook();
                break;
            case "menuViewAllBooks":
                
                break;
            case "menuSearchBooks":
                searchBooks();
                break;
        }
    }
    private void loadBooksFromFile()
    {
        
    }

    private void saveBooksToFile() 
    {
        
    }

    private void saveBooksToFileAs() 
    {
        
    }
    private void showNewBookDialog()
    {
    	try {
         
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Book.fxml"));
            Parent parent = fxmlLoader.load();

            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Book");
            dialogStage.initModality(Modality.WINDOW_MODAL); 
            dialogStage.setScene(new Scene(parent));

           
            dialogStage.showAndWait();

        } catch (Exception e)
    	{
            e.printStackTrace();
            
        }
    }

    private void editSelectedBook()
    {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook == null)
        {
            showAlert("No book selected", "Please select a book to edit.");
            return;
        }
        
    }
    private void deleteSelectedBook() 
    {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null)
        {
            booksData.remove(selectedBook);
        } else
        {
            showAlert("No book selected", "Please select a book to delete.");
        }
    }

    private void searchBooks() 
    {
        
    }

    private void showAlert(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
