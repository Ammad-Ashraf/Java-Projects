
public class Task2 {

	public static void main(String[] args) {
		Book obj1=new Book();
		obj1.settitle("The World");
		obj1.setauthor("Mickeal");
		obj1.setyear(2005);
		
		Book obj2=new Book();
		obj2.settitle("The City");
		obj2.setauthor("Jckson");
		obj2.setyear(2012);
		
		if(obj1.year>obj2.year)
		{
			System.out.println("Book 1 is latest");
		}else
		{
			System.out.println("Book 2 is latest");	
		}
		obj1.Display();
		obj2.Display();
		
		
		

	}

}
