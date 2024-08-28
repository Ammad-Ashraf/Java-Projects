package lab04;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TASK01 
{

	public static void main(String[] args) 
	{
		File task01=new File("data.txt");
		try {
			
			// Writing in the file data.txt
			
			BufferedWriter writer=new BufferedWriter(new FileWriter(task01));
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
			
			// Reading from the file data.txt
			
			BufferedReader reader=new BufferedReader(new FileReader(task01));
			
			// reading line by line
			
			String line;
			System.out.println("Reading line by line\n");
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
			
			// reading word by word
			
			BufferedReader reader1=new BufferedReader(new FileReader(task01));
			String lines;
			System.out.println("\nReading word by word\n");
			while((lines=reader1.readLine())!=null)
			{
				String[] word=lines.split(" ");
				for(String temp:word)
				{
					System.out.print(temp+" ");
				}
				System.out.println();
				
			}
			
			// reading char by char
			
			BufferedReader reader2=new BufferedReader(new FileReader(task01));
			System.out.println("\nReading character by character\n");
			int ch;
			while((ch=reader2.read())!=-1)
			{
				System.out.print((char) ch);
			}
			
			reader.close();
			reader1.close();
			reader2.close();
			
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
