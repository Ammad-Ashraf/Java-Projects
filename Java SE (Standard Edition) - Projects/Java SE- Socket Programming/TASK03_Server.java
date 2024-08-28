import java.io.*;
import java.net.*;

public class I222470_TASK03_Server
{
	public static void main(String[]args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(1997);
			Socket s=ss.accept();
			
			DataInputStream message_client=new DataInputStream(s.getInputStream());
			
			//String filename=message_client.readUTF();
			long  fileSize=message_client.readLong();
			
			File file = new File("recevied.txt");
			
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[100];
            int bytesRead;
            long totalBytesRead = 0;

            while (totalBytesRead < fileSize) 
            {
                bytesRead = message_client.read(buffer, 0, buffer.length);
                if (bytesRead == -1) 
                {
                    break;
                }
                bos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }

            System.out.println("File has been stored on the server\n");
            bos.flush();
            bos.close();
            
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line="";
			System.out.println("You stored file data\n");
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
				System.out.println();
			}
			
			reader.close();
			ss.close();
			message_client.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}