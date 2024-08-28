import java.util.Scanner;
public class Task1 {

	public static void main(String[] args) {
		int[]array= {1,2,3,5,-2,-9,0,0,0};
		int neg=0,pos=0,zero=0;
		for(int number:array)
		{
			if(number>0)
			{
				pos++;
			}else if(number<0)
			{
				neg++;
			}else
			{
				zero++;
			}
		}
		System.out.println("Count of positive numbers "+pos++);
		System.out.println("Count of negative numbers "+neg++);
		System.out.println("Count of zeros "+zero++);
	}

}
