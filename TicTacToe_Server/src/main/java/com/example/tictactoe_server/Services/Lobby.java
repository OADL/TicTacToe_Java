package com.example.tictactoe_server.Services;

import com.example.tictactoe_server.Models.Client;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Lobby extends Thread {
    private ServerSocket serverSocket;

    public Lobby() {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException exception) {
            System.err.println("Couldn't create server socket.");
            throw new RuntimeException("Couldn't create server socket: " + exception.getMessage());
        }
    }

    @Override
    public void interrupt() {
        Communicator.reset();
        super.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Communicator.addClient(new Client(socket));
                Communicator.disconnectClosed();
            } catch (IOException exception) {
                System.err.println("Couldn't connect to client.");
            }
        }
    }
}
