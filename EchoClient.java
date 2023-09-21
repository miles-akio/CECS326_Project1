/*
 * Miles Shinmachi
 * Alina Anwar
 * CECS 326 SEC 02
 */

/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 6007);
            InputStream inputStream = sock.getInputStream();
            OutputStream outputStream = sock.getOutputStream();

            // Message to send to the server
            String message = "Hello there! I am the client.";
            byte[] messageBytes = message.getBytes();

            // Send the message to the server
            outputStream.write(messageBytes);

            // Receive and print the response from the server
            byte[] responseBytes = new byte[1024];
            int bytesRead = inputStream.read(responseBytes);
            String response = new String(responseBytes, 0, bytesRead);
            System.out.println("Received from server: " + response);

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}