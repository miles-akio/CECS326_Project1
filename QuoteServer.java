/*
 * Miles Shinmachi
 * Alina Anwar
 * CECS 326 SEC 02
 */

import java.net.*;
import java.io.*;

public class QuoteServer {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket bound to port 6017
            ServerSocket sock = new ServerSocket(6017);

            // Print a message to indicate that the server is running
            System.out.println("QuoteServer is running...");

            // Continuous loop to accept incoming client connections
            while (true) {

                // Accept a client connection and create a Socket
                Socket client = sock.accept();

                // Create a PrintWriter to send data to the client
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                // Send the predefined quote to the client
                pout.println("Always smile :)");

                // Close the client socket after sending the quote
                // listens for connections
                client.close();
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}