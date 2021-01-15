package Part1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;

public class Server_Socket {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        StringBuilder myB = new StringBuilder();
        boolean exitRecv = false;

        while (true) {

            try (Socket socket = server.accept()) {
            // luetaan pyyntö
            System.out.println("Enter try with resources");
            Scanner scanner = new Scanner(socket.getInputStream());
            System.out.println("Connection received");
            // ...
            String line;
            List<String> myList = new ArrayList<>();
            linesloop: while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0) {
                    break;
                }
                String[] words = line.split(" ");
                for (String string : words) {
                    // System.out.println("String = " + string);
                    if (string.contains("quit")) {
                        exitRecv = true;
                        break linesloop;
                    }
                }
                // System.out.println(scanner.nextLine());
            }
            if (exitRecv == true) {
                System.out.println("TRUEEEEEEEEEEEEE");
                break;
            }
            // else

            PrintWriter myPrnter = new PrintWriter(socket.getOutputStream());
            myPrnter.println("HTTP / 1.1 200 OK");
            myPrnter.println("");
            Files.lines(Paths.get("index.html")).forEach(s -> myPrnter.println(s));
            System.out.println("Sending response to client");

            myPrnter.flush();
            // suljetaan resurssit
            scanner.close();
            myPrnter.close();
            // socket.close();
                          
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Exception " + e.getMessage());
            }


        }
        server.close();  
        System.out.println("Exiting");
    }
}
