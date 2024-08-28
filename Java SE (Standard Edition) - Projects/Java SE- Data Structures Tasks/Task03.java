import java.util.Stack;
public class Task03
{

	public static void main(String[] args)
	{
		Stack<Integer> stacking=new Stack<>();
		stacking.push(20);
		stacking.push(30);
		stacking.push(40);
		stacking.push(50);
		// Print the top element of the stack
		System.out.println("Top element:"+stacking.peek());
		// Bottom element
		Stack<Integer> temp=new Stack<>();
		while(!(stacking.isEmpty()))
		{
			temp.push(stacking.pop());
		}
		System.out.println("Bottom element:"+temp.peek());
		while(!(temp.isEmpty()))
		{
			stacking.push(temp.pop());
		}
		// Stack Size
		System.out.println("Stack Size : "+stacking.size());
		// Stack empty or not
		System.out.println("Is stack empty or not : "+ stacking.isEmpty());
		
		
		

	}

}
