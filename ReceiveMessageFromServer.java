package sumdu.edu.ua.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReceiveMessageFromServer implements Runnable {
    private InputStream inputStreamServer;

    public ReceiveMessageFromServer(InputStream inputStream) {
        this.inputStreamServer = inputStream;
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;

        try {
            while (true) {
                serverMessage = in.readLine();
                if (serverMessage != null) {
                    System.out.println(serverMessage + "\nEnter message: ");
                }
            }
        } catch (IOException e) {

            System.err.println("Error reading server message: " + e.getMessage());
        } finally {

            try {
                in.close();
            } catch (IOException ex) {

                System.err.println("Error closing input stream: " + ex.getMessage());
            }
        }
    }

}