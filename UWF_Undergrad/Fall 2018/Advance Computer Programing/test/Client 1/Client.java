import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * OMAR GARCIA
 * Project 5
 * Advanced Computer Programing
 */
public class Client {
    public static void main(String[] args) throws IOException
    {
        doSomething();
    }

    public static void doSomething() throws IOException
    {
        final int SBAP_PORT = 8888;
        Socket s = new Socket("localhost", SBAP_PORT);

        InputStream instream = s.getInputStream();
        OutputStream outstream = s.getOutputStream();

        Scanner in = new Scanner(instream);
        PrintWriter out = new PrintWriter(outstream);

        Scanner sc = new Scanner(System.in);


        while(true) {
            //String command = "101\n";
            String command = sc.next();
            if(command.equals("quit"))
            {
                break;
            }
            System.out.println("Sending " + command);

            out.print(command + "\n");
            out.flush();
        }
        s.close();
    }
}
