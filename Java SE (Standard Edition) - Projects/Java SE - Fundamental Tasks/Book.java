
public class Book
{
	
	
		
		  public String title,author;
		  public int year;
		  public Book()
		  {
			  title="";
			  author="";
			  year=0;
		  }
		  void settitle(String name)
		  {
			  this.title=name;
		  }
		  void setauthor(String name)
		  {
			  this.author=name;
		  }
		  void setyear(int year)
		  {
			  this.year=year;
		  }
		  void Display()
		  {
			  System.out.println("Book Information");
			  System.out.println("Title : "+this.title);
			  System.out.println("Auhtor : "+this.author);
			  System.out.println("Publication year : "+this.year);
			  
		  }
		
	
}
