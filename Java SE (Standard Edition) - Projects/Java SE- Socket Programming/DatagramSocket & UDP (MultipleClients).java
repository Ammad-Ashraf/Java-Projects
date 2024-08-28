import java.net.*;
import java.io.*;
import java.util.Scanner;
public class I222470_TASK04_MultipleClients 
{

	public static void main(String[] args)
	{
		try
		{
			Socket s=new Socket("localhost",2994);
			System.out.println("\nConnection has been established with the server\n");
			
			try
			{
				Scanner cin=new Scanner(System.in);
				int choice=1;
				while(choice!=-1)
				{
						// Creating multiple files 
						
						String file_name;
						System.out.print("Enter file name : ");
						
						file_name=cin.nextLine();
						
						File files=new File(file_name);
						BufferedWriter writer=new BufferedWriter(new FileWriter(files));
						writer.write("I am Ammad Ashraf");
						
						writer.close();
					
						// Reading data from the file and send it to the selected port
												
						DataOutputStream file_content=new DataOutputStream(s.getOutputStream());
												
						// Reading from the file
									
						BufferedReader reader=new BufferedReader(new FileReader(files));		
						String line;
						while((line=reader.readLine())!=null)
						{
							file_content.writeUTF(line);
						}
						file_content.flush();
									
						System.out.println(file_name +" File has been sent to server");
									
						reader.close();
						file_content.close();
						//System.out.println("Enter -1 to end the program : ");
						choice--;
				}
				cin.close();
					
			}catch(IOException e)
			{
				e.printStackTrace();
			}

			
		}catch (Exception e)
		{
			System.out.println(e);
		}
		//s.close();
		
			
	}

}
