import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Command-line Application.
 * Handles Client connections, processes Client requests, manages
 * global Board object.
 */
public class Server {

    
    public static void main(String argv[]) throws IOException {
        int Port_number = Integer.parseInt(argv[0]);
        ServerSocket socket = new ServerSocket(Port_number);
        Board board = new Board(Integer.parseInt(argv[1]),Integer.parseInt(argv[2]),Arrays.copyOfRange(argv,3,argv.length));
        while (true){
            Socket c_socket = socket.accept();
            
            BoardRunner request = new BoardRunner(board, c_socket);

            Thread thread = new Thread(request);

            thread.start();
        }
      /*
        Scanner in = new Scanner(System.in);
        Integer port = Integer.valueOf(argv[0]);
    
        while (true){
        try {
            ServerSocket socket = new ServerSocket(port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Client = new Client(connection)
    }
        Board board = new Board(1000, 1000, "white", "red", "blue", "green");

        String request = "";
        String cmd = "";

        while (!cmd.equals("DISCONNECT")) {
            System.out.print(">> ");
            request = in.nextLine();
            cmd = request.split(" ")[0];

            switch(cmd) {
                case "GET":
                    break;
                case "POST":

                default:
                    System.err.println("Undefined Command!");
                    break;
            }
        }*/
    }
    private static class BoardRunner implements Runnable{
        private Socket Int_socket = null;
        private Board int_board = null; 
        @Override
        public void run() {
            // TODO Auto-generated method stub
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                out = new PrintWriter(Int_socket.getOutputStream(),true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                in = new BufferedReader(new InputStreamReader(Int_socket.getInputStream()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

            
        }
        public BoardRunner(Board board, Socket socket){
            this.Int_socket = socket;
            this.int_board = board;
        }
    }
  
}
