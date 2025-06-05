/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;

/**
 *
 * @author Nader
 */
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 12345; // Port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            
            Socket socket = serverSocket.accept(); // Accept a client connection
            System.out.println("Client connected: " + socket.getInetAddress());

            // Serve the HTML file
            sendHtmlFile(socket);

            // Chat functionality
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String message;

            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                output.println("Server: " + message); // Echo back to client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendHtmlFile(Socket socket) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Nader/Downloads/m"));
            String line;
            while ((line = br.readLine()) != null) {
               System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}