/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication9;

/**
 *
 * @author Nader
 */
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws UnknownHostException {
       InetAddress a = InetAddress.getLocalHost(); // Server IP address
        int port = 12345; // Server port number

        try (Socket socket = new Socket(a.getHostAddress(), port)) {
           

            // Read and display the HTML content
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            System.out.println("Student CV:");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Chat functionality
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String message;

            System.out.println("Type your messages (type 'exit' to quit):");
            while (!(message = userInput.readLine()).equalsIgnoreCase("exit")) {
                out.println(message);
                System.out.println("Server: " + in.readLine()); // Read response from server
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}