import java.io.*;
import java.net.*;
public class I222470_TASK03_Client
{
	public static void main(String[]args)
	{
		File file_Stored=new File("Intro.txt");
		try
		{
		
						// Creating a file and storing data in that file
			
						BufferedWriter writer=new BufferedWriter(new FileWriter(file_Stored));
						// writing line by line
						writer.write("Hallo!Guten Tag!");
						writer.newLine();
						writer.write("Ist Ammad Ashraf from Islamabad , Pakistan.\n");
						//write word by word
						String[] words= {"I","am","19","years","old.\n"};
						for(String word:words)
						{
							writer.write(word+" ");
						}
						// write char by char
						String dateOfBirth="I was born on 12 of April , 2004.";
						for(char letter:dateOfBirth.toCharArray())
						{
							writer.write(letter);
						}
						// write line by line
						writer.newLine();
						writer.write("I am doing bachelor's in Software Engineering.");
						
						writer.close();
						
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
						// Reading data from that file and send it to the selected port
						
						Socket s=new Socket("localhost",1997);
						System.out.println("\nConnection has been established with the server\n");
						
						DataOutputStream message_server=new DataOutputStream(s.getOutputStream());
						//message_server.writeUTF(file_Stored.getName());
						//message_server.writeLong(file_Stored.length());
						
						// Reading from the file
						
						BufferedReader reader=new BufferedReader(new FileReader(file_Stored));		
						String line;
						while((line=reader.readLine())!=null)
						{
								message_server.writeUTF(line);
						}
						message_server.flush();
						
						System.out.println("File has been sent to server");
						
						reader.close();
						message_server.close();
						s.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}