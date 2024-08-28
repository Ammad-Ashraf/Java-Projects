
public class Student extends Person{
	public String[] courses;
	public int[] grades;
	public int count1;
	public Student(String name,String address)
	{
		super(name,address);
		courses=new String[30];
		grades=new int[30];
		count1=0;
	}
	void addcourseandgrade(String cname,int grade)
	{
		if(count1<30 && grade<=100)
		{
			courses[count1]=cname;
			grades[count1]=grade;
			count1++;	
			System.out.println("Courses and grades added");
		}else
		{
			System.out.println("You can't take more courses");
		}
		
	}
	void displayinformation()
	{
		Double sum=0.0;
		System.out.println("Courses you taken");
		for(int i=0;i<count1;i++)
		{
			System.out.println(i+1 +" - "+courses[i]);
			sum+=grades[i];
			
		}
		Double average=sum/(count1+1);
		System.out.println("Your's average grade : "+average);
		
	}
	
}
