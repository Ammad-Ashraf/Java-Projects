import java.sql.*;

public class Appointments implements AppointmentSystem
{
	public void showingDetails(Connection conn)
	{
		  try {
	            Statement statement = conn.createStatement();
	            String query = "SELECT * FROM Appointments";
	            ResultSet rs = statement.executeQuery(query);
	            
	            while (rs.next())
	            {
	            	 int id = rs.getInt("id");
	                 int patientId = rs.getInt("patient_id");
	                 int doctorId = rs.getInt("doctor_id");
	                 String appointmentDate = rs.getString("appointment_date");
	                 String appointmentTime = rs.getString("appointment_time");
	                 String reason = rs.getString("reason");
	                 String status = rs.getString("status");

	                 System.out.println("ID: " + id + ", Patient ID: " + patientId + ", Doctor ID: " + doctorId + 
	                                    ", Appointment Date: " + appointmentDate + ", Appointment Time: " + appointmentTime + 
	                                    ", Reason: " + reason + ", Status: " + status);
	            }
	            rs.close();
	            statement.close();

	        } catch (SQLException e)
			   {
		            e.printStackTrace();
		       }
	}
	public void scheduleAppointment(Connection conn, int patientId, int doctorId, Date date, Time time, String reason) throws SQLException
    {
        String appointment = "INSERT INTO Appointments (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (?, ?, ?, ?, ?, 'Scheduled')";
        try (PreparedStatement pstmt = conn.prepareStatement(appointment))
        {
            pstmt.setInt(1, patientId);
            pstmt.setInt(2, doctorId);
            pstmt.setDate(3, date);
            pstmt.setTime(4, time);
            pstmt.setString(5, reason);
            pstmt.executeUpdate();
            System.out.println("Appointment scheduled.");
            System.out.println("");
        }
    }

    public void cancelAppointment(Connection conn, int appointmentId) throws SQLException
    {
        String cancel = "UPDATE Appointments SET status='Canceled' WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(cancel))
        {
            pstmt.setInt(1, appointmentId);
            pstmt.executeUpdate();
            System.out.println("Appointment canceled.");
            System.out.println("");
        }
        /*String deleteSQL = "DELETE FROM Appointments WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL))
        {
            pstmt.setInt(1, appointmentId);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) 
            {
                System.out.println("Appointment deleted.");
            } else 
            {
                System.out.println("No appointment found with ID: " + appointmentId);
            }
            System.out.println(""); 
        }
        */
    }

};
