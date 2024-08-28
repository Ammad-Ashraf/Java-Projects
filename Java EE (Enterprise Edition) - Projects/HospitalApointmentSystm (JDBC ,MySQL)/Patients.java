import java.sql.*;
public class Patients implements AppointmentSystem
{
		public void showingDetails(Connection conn)
		{
			  try {
		            Statement statement = conn.createStatement();
		            String query = "SELECT * FROM Patients";
		            ResultSet rs = statement.executeQuery(query);
		            
		            while (rs.next())
		            {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                int age = rs.getInt("age");
		                String contactInfo = rs.getString("contact_info");
		                String symptoms = rs.getString("symptoms");

		                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Contact Info: " + contactInfo + ", Symptoms: " + symptoms);
		            }

	
		            rs.close();
		            statement.close();
		            

		        } catch (SQLException e)
				   {
			            e.printStackTrace();
			       }
		}
		public void addPatient(Connection conn, String name, int age, String contactInfo, String symptoms) throws SQLException
		{
        String patient = "INSERT INTO Patients (name, age, contact_info, symptoms) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(patient)) 
	        {
	            pstmt.setString(1, name);
	            pstmt.setInt(2, age);
	            pstmt.setString(3, contactInfo);
	            pstmt.setString(4, symptoms);
	            pstmt.executeUpdate();
	            System.out.println("Patient record added.");
	            System.out.println("");
	        }
		}
};
