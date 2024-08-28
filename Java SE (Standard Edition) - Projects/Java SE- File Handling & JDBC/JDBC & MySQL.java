
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Main
{
public static void main(String[] args) 
	{
		
		String username = "root";
		String password = "Ammad1122.";
		try 
		{
			Connection my_Connection=null;
			ResultSet my_Results=null;
			Statement my_Statement=null;
			
			my_Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/",username,password);
			System.out.println("Connection has been established with the database successfully\n");
			
			my_Statement=my_Connection.createStatement();
			
			my_Statement.execute("Use mydb;");
			
			// Create a table of name Students
			
			String creating_table="CREATE TABLE IF NOT EXISTS Students ("+"id INT(2) PRIMARY KEY,"
			+"name VARCHAR(15),"+"age INT(3),"+"grade VARCHAR(2))";
			my_Statement.execute(creating_table);
			
			// Insert data in rows 
			
	    String insert_data1 = "INSERT INTO Students (id,name,age,grade) VALUES (12,'Ammad',19,'A+')";
	    my_Statement.executeUpdate(insert_data1);
	    System.out.println("Student 1 record added.\n");
	    
	    String insert_data2 = "INSERT INTO Students (id,name,age,grade) VALUES (18,'Zain',20,'F')";
	    my_Statement.executeUpdate(insert_data2);
	    System.out.println("Student 2 record added.\n");
	    
	    String insert_data3 = "INSERT INTO Students (id,name,age,grade) VALUES (14,'Hamza',18,'D-')";
	    my_Statement.executeUpdate(insert_data3);
	    System.out.println("Student 3 record added.\n");

	    // show all data from the table 
	    System.out.println("Students Records\n");
	    my_Results=my_Statement.executeQuery("Select * from Students");
	    while(my_Results.next())
	    {
	    	System.out.println("ID : "+my_Results.getInt("id")+" Name : "+my_Results.getString("name")+" Age : "+my_Results.getString("grade"));
	    }
	    
	    // delete a record based on student id
	    
	    String delete_record="DELETE FROM Students WHERE id=14";
	    my_Statement.executeUpdate(delete_record);
	    System.out.println("\nStudent Record of id = 14 has been removed \n");
	    
	    // update an existing record
	    
	    String update_Record="UPDATE Students SET grade='B+' WHERE id=12";
	    my_Statement.executeUpdate(update_Record);
	    System.out.println("\nGrade of Student id = 12 has been updated \n");
	    
	    // show all data from the table after deletion and update 
	    System.out.println("Students Records after delete and update\n");
	    my_Results=my_Statement.executeQuery("Select * from Students");
	    while(my_Results.next())
	    {
	    	System.out.println("ID : "+my_Results.getInt("id")+" Name : "+my_Results.getString("name")+" Age : "+my_Results.getInt("age")+" Grade : "+my_Results.getString("grade"));
	    }
	    
	    
		my_Connection.close();
		my_Statement.close();
		my_Results.close();
		} catch (SQLException exc)
		{
		exc.printStackTrace();
		}
	}
}