import java.util.LinkedList;
import java.util.Scanner;

public class Task01 
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
        System.out.println("LinkedList after adding elements at first positions : " + linklist);
        System.out.println("Elements for last positions");
        for(int i=0;i<last;i++)
        {
        	elements=cin.nextInt();
        	linklist.addLast(elements);
        }
        System.out.println("LinkedList after adding elements at last positions : " + linklist);
        
        linklist.clear();
        System.out.println("LinkedList after clearing: " + linklist);
        
    }
}
