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
             csocket = n_socket.accept();
             
        } catch (Exception e) {
            //TODO: handle exception
        }
        PrintWriter out = new PrintWriter(csocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
        String inputLine,outputLine;
        outputLine = "Server here";
        out.println(outputLine);
        while ((inputLine = in.readLine())!= null){
            out.println(outputLine + " Repeat");

        }
        out.close();
        in.close();
        csocket.close();
        n_socket.close();

    }
}
