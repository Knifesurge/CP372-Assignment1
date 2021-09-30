import java.util.Scanner;

/**
 * Command-line Application.
 * Handles Client connections, processes Client requests, manages
 * global Board object.
 */
public class Server {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

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
        }
    }
}
