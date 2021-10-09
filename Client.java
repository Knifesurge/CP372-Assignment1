import javax.swing.*;
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
public class Client extends SwingWorker {

    private static Socket client_socket;
    private boolean connected = false;
    private PrintWriter output;
    private BufferedReader input;
    private BufferedReader stdIn;
    private String serverAddr;
    private int serverPort;
    private static JTextArea textArea;

    public Client(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    protected String doInBackground() {
        String serverResp = "";  // Messages from server
        try {
            while ((serverResp = input.readLine()) != null) {
                //if(UserCommand.equals("DISCONNECT")) break;
                System.out.println(serverResp);
                textArea.append("Server: " + serverResp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverResp;
    }

    public boolean isConnected() { return connected; }

    public void sendMessage(String[] message, boolean argsRequired) {
        StringBuilder outMsg = new StringBuilder();
        if (!argsRequired) {
            // Command takes no arguments, just send the command
            outMsg.append(message[0]);
        } else {
            // Send the arguments off as well
            for (String s : message) {
                outMsg.append(s + " ");
            }
        }
        System.out.println("Sending message: " + outMsg.toString());
        output.println(outMsg.toString());  // Sends message to Server socket
        textArea.append("Client: " + outMsg.toString() + "\n");
    }

    public void connect(String ip, int port) {
        this.serverAddr = ip;
        this.serverPort = port;
        try {
            client_socket = new Socket(ip, port);
            output = new PrintWriter(client_socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            connected = true;
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host, please retry!");
        } catch (IOException e) {
            System.err.println("Unable to read/write, please try again!");
        }
        System.out.println("Connected to: " + ip + ":" + port);
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
}
