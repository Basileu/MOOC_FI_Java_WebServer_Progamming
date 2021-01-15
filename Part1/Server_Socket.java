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
            Socket socket = server.accept();

            // luetaan pyyntö
            Scanner scanner = new Scanner(socket.getInputStream());
            // ...
            String line;
            List<String> myList = new ArrayList<>();
            linesloop:
            while (scanner.hasNextLine()) {
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
                System.out.println(scanner.nextLine());
            }
            if (exitRecv == true) {
                System.out.println("TRUEEEEEEEEEEEEE");
                break;
            } else {

                myB.append("HTTP / 1.1 200 OK");
                Files.lines(Paths.get("index.html")).forEach(s -> myB.append(s));
                System.out.println(myB);

            }
            // kirjoitetaan vastaus
            PrintWriter myPrnter = new PrintWriter(socket.getOutputStream());
            // ...
//            System.out.print(myB.toString());
            myPrnter.print(myB.toString());
            myPrnter.flush();
            // suljetaan resurssit
            scanner.close();
            myPrnter.close();
            socket.close();
            server.close();
        }
        System.out.println("Exiting");
    }
}
