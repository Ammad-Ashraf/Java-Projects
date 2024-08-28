import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;
public class Task02 
{

	public static void main(String[] args)
	{
		        
		        LinkedList<Integer> linklist=new LinkedList<>();
		        int first,last;
		        System.out.println("Elements you want to enter at first positions : ");
		        Scanner cin=new Scanner(System.in);
		        first=cin.nextInt();
		        System.out.println("Elements you want to enter at Last positions : ");
		        last=cin.nextInt();
		        System.out.println("Elements for first positions");
		        int elements;
		        for(int i=0;i<first;i++)
		        {
		        	elements=cin.nextInt();
		        	linklist.addFirst(elements);
		        }
		        System.out.println("Elements for last positions");
		        for(int i=0;i<last;i++)
		        {
		        	elements=cin.nextInt();
		        	linklist.addLast(elements);
		        }
		        int position=0;
		        System.out.println("Enter the starting poistion of iteration ");
		        position=cin.nextInt();
		        if(position<0 && position>=linklist.size())
		        {
		        	System.out.println("Invalid Position");
		        	return;
		        }
		        ListIterator<Integer> iterator=linklist.listIterator(position);
		        System.out.println("Iterating from position " + position + ":");
		        while (iterator.hasNext()) 
		        {
		            System.out.println(iterator.next());
		        }
		        
		        linklist.clear();
		        System.out.println("LinkedList after clearing: " + linklist);
		        
	}
		

	

}
