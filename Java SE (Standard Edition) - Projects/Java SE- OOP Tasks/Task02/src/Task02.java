
public class Task02 
{

	public static void main(String[] args) 
	{
		
        Course javaCourse = new Course("CS101", "Introduction to Java");
        Course dataStructures = new Course("CS102", "Data Structures");

        
        Student ali = new Student(1, "Ali",20);
        Student hamza = new Student(2, "Hamza",19);
        Student zain = new Student(3, "Zain",23);

        
        Enrollment enrollmentSystem = new Enrollment();

       
        enrollmentSystem.enrollStudent(javaCourse, ali);
        enrollmentSystem.enrollStudent(javaCourse,hamza);
        enrollmentSystem.enrollStudent(dataStructures, ali);
        enrollmentSystem.enrollStudent(dataStructures, zain);

        
        enrollmentSystem.enrollStudent(javaCourse, ali);

       
        System.out.println("Before dropping any student:");
        enrollmentSystem.displayEnrolledStudents(javaCourse);

       
        enrollmentSystem.dropStudent(javaCourse, ali);

        
        System.out.println("\nAfter dropping Ali:");
        enrollmentSystem.displayEnrolledStudents(javaCourse);

       
        System.out.println("\nEnrolled students in Data Structures course:");
        enrollmentSystem.displayEnrolledStudents(dataStructures);
    }

	

}
