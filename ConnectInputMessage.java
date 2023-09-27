package sumdu.edu.ua.client;

import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {
    private Socket serverConnect;
    private InputStream inputStreamServer;

    public ConnectInputMessage() {
        try {
            serverConnect = new Socket("localhost", 8887);
            inputStreamServer = serverConnect.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;

        while (true) {
            try {
                serverMessage = in.readLine();
                if (serverMessage != null) {
                    System.out.println(serverMessage + '\n');
                    break;
                }
            } catch (IOException e) {
                System.err.println("Error reading server message: " + e.getMessage());
            }
        }

        PrintWriter out = null;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));

        String userMessage = null;

        while (true) {
            System.out.println("Enter message: ");
            try {
                userMessage = inputUser.readLine();
                if (userMessage.trim().isEmpty()) {
                    System.out.println("Помилка: Пусте повідомлення. Будь ласка, введіть щось корисне.");
                    continue;
                }
                out = new PrintWriter(serverConnect.getOutputStream(), true);
                out.println(userMessage);
            } catch (IOException e) {
                System.err.println("Помилка вводу/виводу: " + e.getMessage());
            }
        }
    }

    public InputStream getInputStreamServer() {
        return inputStreamServer;
    }
}