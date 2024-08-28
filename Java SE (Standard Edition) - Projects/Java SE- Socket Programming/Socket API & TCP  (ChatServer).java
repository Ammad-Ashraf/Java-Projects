import java.io.IOException;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatServer 
{
	
    public static void main(String[] args) throws IOException 
    {
    	Scanner cin=new Scanner(System.in);
        int port = 5558;
        DatagramSocket serverSocket = new DatagramSocket(port);
        System.out.println("-----------------------------");
        System.out.println("Server started on port " + port);
        System.out.println("-----------------------------\n");

        while (true) 
        {
            // DatagramPacket (receive)
            byte[] buffer = new byte[1030];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            // Receive Message
            serverSocket.receive(receivePacket);

            // Sender information
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Extract message
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

            if (message.equalsIgnoreCase("Goodbye"))
            {
            	System.out.println("--------------------------------------------------------");
                System.out.println("Client disconnected: " + clientAddress + " : " + clientPort);
                System.out.println("--------------------------------------------------------\n");
                break;
            }
            
            System.out.println(" Client  \n(" + clientAddress + " : " + clientPort +  ") -  " + message);
            System.out.print("\nServer : ");
            String response;
            response=cin.nextLine();
            
            // DatagramPacket (send)
            DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.length(), clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
        cin.close();
        serverSocket.close();
        System.out.println("-------------------------");
        System.out.println("Server has been stopped");
        System.out.println("-------------------------");
    }
}
