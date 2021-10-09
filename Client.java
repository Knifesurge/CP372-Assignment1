import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;



import java.io.*;
import java.net.UnknownHostException;


/**
 * GUI Application.
 *
 * Connects to Server, sends requests to Server, displays responses.
 */
public class Client implements Runnable {

    private static Socket client_socket;
    private PrintWriter output;
    private BufferedReader input;
    private BufferedReader stdIn;
    private String serverAddr;
    private int serverPort;

    public Client() {

    }

    public void connect(String ip, int port) {
        this.serverAddr = ip;
        this.serverPort = port;
        try {
            client_socket = new Socket(ip, port);
            output = new PrintWriter(client_socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host, please retry!");
        } catch (IOException e) {
            System.err.println("Unable to read/write, please try again!");
        }
    }

    public void close() {
        try {
            output.close();
            input.close();
            client_socket.close();
        } catch (IOException e) {
            System.err.println("Error closing in/out streams or socket!");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String UserCommand;
        //UserCommand = stdIn.readLine();
        try {
            while ((UserCommand = stdIn.readLine()) != null) {
                //if(UserCommand.equals("DISCONNECT")) break;
                output.println(UserCommand);
                System.out.println(input.readLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        close();
    }
}
