import java.net.*;
import java.io.*;
public class I222470_TASK04_DefaultServer
{

	public static void main(String[] args) 
	{
		try
		{
			ServerSocket ssocket=new ServerSocket(2994);
			while(true)
			{
				Socket socket=ssocket.accept();
				
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
