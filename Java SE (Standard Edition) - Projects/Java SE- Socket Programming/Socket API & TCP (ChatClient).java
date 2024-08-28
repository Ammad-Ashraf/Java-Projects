import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatClient
{

    public static void main(String[] args) throws IOException
    {
    	Scanner scanner = new Scanner(System.in);
        String serverAddress = "localhost";
        int serverPort = 5558;
        
        int clientPort = (int) (Math.random() * 65535);
        DatagramSocket clientSocket = new DatagramSocket(clientPort);

        System.out.println("------------------------------------------");
        System.out.println("\tUDP-based Chat Application");
        System.out.println("------------------------------------------");
        System.out.println("\n... Start Chating with the Server ...\n");
        while (true)
        {
        	// Client message
        	System.out.println("______________________________________\n");
            System.out.print("\tYou: ");
            String message = scanner.nextLine();
            System.out.println("______________________________________");
            
            // DatagramPacket (send)
            byte[] data = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, InetAddress.getByName(serverAddress), serverPort);
            // Send packet
            clientSocket.send(sendPacket);

            // DatagramPacket (receive)
            byte[] buffer = new byte[1030];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            // receive packet
            clientSocket.receive(receivePacket);

            // Extracting message
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("--------------------------------------");
            // Server Message
            System.out.println("\tServer: " + receivedMessage);
            System.out.println("--------------------------------------");

        }
     
    }
}
