import java.sql.*;

public class HospitalAppointmentSystem 
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/HospitalDB";
    private static final String USER = "root";
    private static final String PASS = "Ammad1122.";
    private static Patients patient;
    private static Doctor doctor;
    private static Appointments appointment;

    public static void main(String[] args)
    {
        try 
        {
            patient=new Patients();
            doctor=new Doctor();
            appointment=new Appointments();
            
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.execute("USE HospitalDB");

            // Patients table
            String patientsTable = "CREATE TABLE IF NOT EXISTS Patients (" +
                                         "id INT AUTO_INCREMENT PRIMARY KEY," +
                                         "name VARCHAR(50)," +
                                         "age INT," +
                                         "contact_info VARCHAR(100)," +
                                         "symptoms TEXT);";
            statement.execute(patientsTable);
            System.out.println("Patients table created.");
            System.out.println("");
            // Doctors table
            String doctorsTable = "CREATE TABLE IF NOT EXISTS Doctors (" +
                                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                                        "name VARCHAR(50)," +
                                        "specialization VARCHAR(100)," +
                                        "contact_info VARCHAR(100));";
            statement.execute(doctorsTable);
            System.out.println("Doctors table created.");
            System.out.println("");
            // Appointments table
            String appointmentsTable = "CREATE TABLE IF NOT EXISTS Appointments (" +
                                             "id INT AUTO_INCREMENT PRIMARY KEY," +
                                             "patient_id INT," +
                                             "doctor_id INT," +
                                             "appointment_date DATE," +
                                             "appointment_time TIME," +
                                             "reason TEXT," +
                                             "status VARCHAR(20)," +
                                             "FOREIGN KEY (patient_id) REFERENCES Patients(id)," +
                                             "FOREIGN KEY (doctor_id) REFERENCES Doctors(id));";
            statement.execute(appointmentsTable);
            System.out.println("Appointments table created.");
            System.out.println("");

            // Different Operations of the scenarios
            
            // Add a patient
            patient.addPatient(connection, "Will", 35, "123-456-7890", "Brain Tumor");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Patients Record\n");
            patient.showingDetails(connection);
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            
            // Add a doctor
            int doctorId = doctor.addDoctor(connection, "Dr. Lecter", "Neurologist", "456-789-1230");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Doctor Record\n");
            doctor.showingDetails(connection);
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            
            // Scheduling an appointment
            appointment.scheduleAppointment(connection, 1, doctorId, Date.valueOf("2024-03-25"), Time.valueOf("14:00:00"), "Consulation");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Appointments Record\n");
            appointment.showingDetails(connection);
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            
            // Canceling an appointment
            appointment.cancelAppointment(connection, 1);
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Appointments Record (after cancelling)\n");
            appointment.showingDetails(connection);
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            
            // Updating the doctor schedule
            doctor.updateDoctorSchedule(connection, doctorId, "567-890-1234");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Doctor Record (after updating the schedule)\n");
            doctor.showingDetails(connection);
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            
            statement.executeUpdate("DROP TABLE IF EXISTS Appointments");
            statement.executeUpdate("DROP TABLE IF EXISTS Patients");
            statement.executeUpdate("DROP TABLE IF EXISTS Doctors");
            
            
            // Close connection
            connection.close();
            statement.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
