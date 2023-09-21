/*
 * Miles Shinmachi
 * Alina Anwar
 * CECS 326 SEC 02
 */

/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6007);

            while (true) {
                Socket client = sock.accept();
                InputStream inputStream = client.getInputStream();
                OutputStream outputStream = client.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead;

                // Read data from the client using InputStream, which deals with bytes
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    // Write the data back to the client
                    outputStream.write(buffer, 0, bytesRead);
                }

                // The read() method in the java.io.InputStream class returns −1 when the client
                // has closed its end of the socket connection.
                // This signals the end of data, and the server will continue to listen for new
                // client connections.
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}