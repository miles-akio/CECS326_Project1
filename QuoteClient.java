/*
 * Miles Shinmachi
 * Alina Anwar
 * CECS 326 SEC 02
 */

import java.net.*;
import java.io.*;

public class QuoteClient {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket sock = new Socket("127.0.0.1", 6017);

            // Create a BufferedReader to read data from the socket's input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            // Read and print the quote from the server
            String quote = reader.readLine();
            System.out.println("Quote of the Day: " + quote);

            // Close the client socket
            sock.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}