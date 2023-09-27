package sumdu.edu.ua.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import sumdu.edu.ua.server.ChatServer;

public class ClientThread implements Runnable {
    Socket clientSocket;
    ChatServer chatServer;
    int numberClient;

    public ClientThread(Socket clientSocket, ChatServer chatServer, int number) {
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
        this.numberClient = number;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            try {
                System.out.println("Client №" + numberClient + " connected.");
                out.println("Client №" + numberClient + ".");
                String clientMessage;

                while (true) {
                    clientMessage = in.readLine();
                    if (clientMessage != null && !"exit".equals(clientMessage)) {
                        System.out.println("Client №" + numberClient + ": " + clientMessage);
                        chatServer.sendMessageForAllClient(numberClient, clientMessage);
                    } else {
                        break;
                    }
                }
            } finally {
                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Client №" + numberClient + " disconnected.");
            }
        } catch (IOException e) {
            System.err.println("Error in client thread: " + e.getMessage());
        }
    }

}