package AP.group30.StardewValley.network;

import AP.group30.StardewValley.views.GameScreen;

import java.io.*;
import java.net.*;
import java.net.Socket;


public class GameServer {
    private static final int PORT = 12345;
    private ServerSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
            // Handle each client in its own thread
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    public void stop() throws IOException {
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
            System.out.println("Server stopped.");
        }
    }

    // Entry point
    public static void main(String[] args) {
        GameServer server = new GameServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private BufferedWriter out;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Set up I/O streams
                in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                // Simple handshake
                String line = in.readLine();
                System.out.println("Received from client: " + line);
                if ("HELLO".equals(line)) {
                    out.write("WELCOME\n");
                } else {
                    out.write("UNKNOWN\n");
                }
                out.flush();

                // Echo loop (replace with game logic later)
                while ((line = in.readLine()) != null) {
                    System.out.println("Client says: " + line);
                    out.write("ECHO: " + line + "\n");
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println("Client disconnected: " + e.getMessage());
            } finally {
                // Cleanup
                try {
                    if (socket != null) socket.close();
                } catch (IOException ignored) {}
            }
        }
    }
}

