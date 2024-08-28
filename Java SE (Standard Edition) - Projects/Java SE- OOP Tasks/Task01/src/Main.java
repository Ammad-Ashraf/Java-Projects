
public class Main {

	public static void main(String[] args) {
		Student s1=new Student("Ammad","Lahore");
	
		s1.addcourseandgrade("Prob And Stats",70);
		s1.addcourseandgrade("Data Structures",90);
		s1.addcourseandgrade("German Lang",80);
		
		s1.displayinformation();
		
		Professor p1=new Professor("Ashraf","Islambad");
		p1.addcourses("Linear Algebra");
		p1.addcourses("PF");
		p1.addcourses("OOP");
		
		p1.removecourse("PF");
		

		

	}

}
