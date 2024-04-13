import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * OMAR GARCIA
 * Project 5
 * Advanced Computer Programing
 */
public class Server {

    public static void main(String[] args) throws IOException {

        final int SBAP_PORT = 8889;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for players to connect...");


        while(true)
        {
            final Game ticktock = new Game();
            Socket s = server.accept();
            System.out.println("Player1 connected.");
            Thread service = new Thread(new Service(s, ticktock));
            service.start();

            Socket s2 = server.accept();
            System.out.println("Player2 connected.");
            Thread service2 = new Thread(new Service(s2, ticktock));
            service2.start();
        }
    }

}
