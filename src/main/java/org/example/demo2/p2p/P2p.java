package org.example.demo2.p2p;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class P2p {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        new Thread(() -> startServer()).start();

        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        System.out.print("Connect to peer? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Enter peer IP (e.g., localhost): ");
            String ip = scanner.nextLine();

            System.out.print("Enter message to send: ");
            String message = scanner.nextLine();

            sendMessageToPeer(ip, PORT, message);
        }
    }

    private static void startServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                new Thread(() -> handleClient(client)).start();
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static void handleClient(Socket client) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String msg = in.readLine();
            System.out.println("Received from peer: " + msg);
        } catch (IOException e) {
            System.err.println("Error reading from peer: " + e.getMessage());
        }
    }

    private static void sendMessageToPeer(String ip, int port, String message) {
        try (Socket socket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println(message);
            System.out.println("Message sent to peer");

        } catch (IOException e) {
            System.err.println("Failed to connect to peer: " + e.getMessage());
        }
    }
}