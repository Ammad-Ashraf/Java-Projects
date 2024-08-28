import java.util.Queue;
import java.util.LinkedList;
public class Task04 
{

	public static void main(String[] args) 
	{
		Queue<Integer> queueing=new LinkedList<>();
		// Enqueue elements
		queueing.offer(30);
		queueing.offer(40);
		queueing.offer(50);
		queueing.offer(60);
		queueing.offer(70);
		// first element
		System.out.println("First element of queue : "+queueing.peek());
		// dequeue elements
		Integer lastelement=null;
		while(!(queueing.isEmpty()))
		{
			lastelement=queueing.poll();
			System.out.println("Dequeued Element : "+lastelement);
		}
		// Last element
		System.out.println("Rear element of queue : "+lastelement);

	}

}
