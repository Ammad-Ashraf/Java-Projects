import java.sql.*;

public class Doctor implements AppointmentSystem
{
	public void showingDetails(Connection conn)
	{
		  try {
	            Statement statement = conn.createStatement();
	            String query = "SELECT * FROM Doctors";
	            ResultSet rs = statement.executeQuery(query);
	            
	            while (rs.next())
	            {
	            	int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String specialization = rs.getString("specialization");
	                String contactInfo = rs.getString("contact_info");

	                System.out.println("ID: " + id + ", Name: " + name + ", Specialization: " + specialization + ", Contact Info: " + contactInfo);
	            }

	    
	            rs.close();
	            statement.close();

	        } catch (SQLException e)
			   {
		            e.printStackTrace();
		       }
	}
	public int addDoctor(Connection conn, String name, String specialization, String contactInfo) throws SQLException 
    {
        String doctor = "INSERT INTO Doctors (name, specialization, contact_info) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(doctor, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setString(1, name);
            pstmt.setString(2, specialization);
            pstmt.setString(3, contactInfo);
            pstmt.executeUpdate();
            System.out.println("Doctor record added.");
            System.out.println("");
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys())
            {
                if (generatedKeys.next()) 
                {
                    return generatedKeys.getInt(1);
                } else
                {
                    throw new SQLException("Creating doctor failed, no ID obtained.");
                }
            }
        }
    }
	public void updateDoctorSchedule(Connection conn, int doctorId, String newContactInfo) throws SQLException
    {
        String update = "UPDATE Doctors SET contact_info=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(update))
        {
            pstmt.setString(1, newContactInfo);
            pstmt.setInt(2, doctorId);
            pstmt.executeUpdate();
            System.out.println("Doctor schedule updated.");
            System.out.println("");
        }
    }
};
