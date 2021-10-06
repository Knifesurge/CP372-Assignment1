import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;



import java.io.*; 


/**
 * GUI Application.
 *
 * Connects to Server, sends requests to Server, displays responses.
 */
public class Client implements Runnable {
    public static void main(String argv[]) throws IOException{
        PrintWriter output = null;
        BufferedReader input = null,stdIn = null;
        String localHost = argv[0];
        int port = Integer.parseInt(argv[1]);
        Socket Client_Socket = null;
        try {
            Client_Socket = new Socket(localHost,port);
            output = new PrintWriter(Client_Socket.getOutputStream(),true);
            input = new BufferedReader(new InputStreamReader(Client_Socket.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String UserCommand;
        //UserCommand = stdIn.readLine();
        while ((UserCommand = stdIn.readLine())!=null){
            //if(UserCommand.equals("DISCONNECT")) break;
            output.println(UserCommand);
            System.out.println(input.readLine());
           
        }
        output.close();
        input.close();
        Client_Socket.close();




    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
}
