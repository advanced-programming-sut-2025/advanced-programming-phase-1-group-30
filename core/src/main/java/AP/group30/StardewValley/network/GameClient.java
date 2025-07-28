package AP.group30.StardewValley.network;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameClient {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(HOST, PORT);
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner console    = new Scanner(System.in);
        ) {
            System.out.println("Connected to server at " + HOST + ":" + PORT);

            // Send handshake
            out.write("HELLO\n");
            out.flush();

            // Read response
            String response = in.readLine();
            System.out.println("Server responded: " + response);

            // Simple user → server console loop
            System.out.println("Type messages to send to the server. Type 'quit' to exit.");
            String line;
            while (!(line = console.nextLine()).equalsIgnoreCase("quit")) {
                out.write(line + "\n");
                out.flush();
                // Read echo
                String reply = in.readLine();
                System.out.println("Server: " + reply);
            }

            System.out.println("Closing connection.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
