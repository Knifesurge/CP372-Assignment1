import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;



public class mockserver {
    public static void main (String[] args) throws IOException{
        ServerSocket n_socket = null;
        Socket csocket = null;
         
        try {
             n_socket = new ServerSocket(4444);
      
        } catch (Exception e) {
            //TODO: handle exception
        }
        while (true){
            Socket connection = n_socket.accept();
            ClientHandler request = new ClientHandler(connection);
            Thread thread = new Thread(request);
            thread.start();
        }
       

    }
}
class ClientHandler implements Runnable{
    private final Socket clientSocket;
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader in=null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String inputLine,outputLine;
        System.out.println("Connection successfull");
        try {
            int i = 0;
            while ((inputLine = in.readLine())!= null){
                outputLine = inputLine;
                out.println(outputLine + " Repeat " + i);
                i++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.close();
        try {
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
    
}
