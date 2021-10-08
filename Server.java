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
            String Inline, Outline;
            Outline = int_board.inputParser(null);
            out.println(Outline);
            try {
                while ((Inline = in.readLine())!= null){
                    Outline = int_board.inputParser(null);
                    out.println(Outline);
                    if (Outline.equals("DISCONNECT")) break;
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
        public BoardRunner(Board board, Socket socket){
            this.Int_socket = socket;
            this.int_board = board;
        }
    }
  
}
