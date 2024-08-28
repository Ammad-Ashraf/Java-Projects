import java.util.ArrayList;
public class Professor extends Person {
	public ArrayList<String> courses;
	public int count1;
	public Professor(String name,String address)
	{
		super(name,address);
		count1=0;
		courses=new ArrayList<>();
	}
	void addcourses(String cname)
	{
		if(count1<5)
		{
			courses.add(cname);
			count1++;
			System.out.println("Course added");
		}else
		{
			System.out.println("You can't register more courses");
		}
	}
	void removecourse(String cname)
	{
		boolean result=false;
		for(int i=0;i<courses.size();i++)
		{
			if(courses.get(i)==cname)
			{
				courses.remove(cname);
				System.out.println("Course removed");
				result=true;
				
			}
		}
		if(result==false)
		{
			System.out.println("Course not found");
		}
	}
	
}
