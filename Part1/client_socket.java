package Part1;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client_socket {

    public static void main(String[] args) {
        // String osoite = "www.helssainki.fi";
        String osoite = "http://localhost:8080";

        int portti = 80;

        // muodosta yhteys
        try (Socket socket = new Socket(osoite, portti)) {
            // lähetä viesti palvelimelle
            PrintWriter kirjoittaja = new PrintWriter(socket.getOutputStream());
            kirjoittaja.println("GET / HTTP/1.1");
            kirjoittaja.println("Host: " + osoite);
            kirjoittaja.println();
            kirjoittaja.flush();

            // lue vastaus palvelimelta
            Scanner lukija = new Scanner(socket.getInputStream());
            while (lukija.hasNextLine()) {
                String line = lukija.nextLine();
                if (line.contains("404"))
                    System.out.println("404 found");
                else
                    System.out.println(line);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception caught " + e.getMessage());
        }

    }
}
