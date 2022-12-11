package com.example.tictactoe_server.Models;

import com.example.tictactoe_server.Enums.AuthenticationType;
import com.example.tictactoe_server.Enums.Commands;
import com.example.tictactoe_server.Repository.UserRepository;
import com.example.tictactoe_server.Services.Communicator;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Objects;

public class Client extends Thread {
    private User user;
    private Socket socket;
    private DataInputStream inputStream;
    private PrintStream printStream;
    private boolean isConnected;
    private boolean isBusy;

    public Client(Socket socket) {
        try {
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.printStream = new PrintStream(socket.getOutputStream());
            this.isConnected = true;
            this.isBusy = false;
            AuthenticationType authenticationType = AuthenticationType.value(inputStream.readLine());
            String name = inputStream.readLine();
            String password = inputStream.readLine();
            User user = new User(null, name, password);
            switch (Objects.requireNonNull(authenticationType)) {
                case LOGIN:
                    login(user);
                    break;
                case SIGNUP:
                    signup(user);
                    break;
                default:
                    isConnected = false;
            }
        } catch (IOException ioException) {
            System.err.println("Couldn't initialize client.");
            this.isConnected = false;
        }
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public long getId() {
        return this.user.getId();
    }

    public User getUser() {
        return user;
    }

    private void signup(User user) {
        this.user = UserRepository.createUser(user);
        sendMessage("approved");
    }

    private void login(User user) {
        User dbUser = UserRepository.findByName(user.getName());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            this.user = dbUser;
            sendMessage("approved");
        } else {
            isConnected = false;
            sendMessage("rejected");
        }
    }

    public void sendMessage(String message) {
        printStream.println(message);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Commands command = Commands.value(inputStream.readLine());
                switch (Objects.requireNonNull(command)) {
                    case LIST_ALL:
                        sendAllUsers();
                        break;
                    case CONNECT_TO:
                    case ACCEPT_CONNECTION:
                    case MOVE:
                        break;
                }
            } catch (IOException e) {
                isConnected = false;
                throw new RuntimeException(e);
            }
        }
    }

    public void sendAllUsers() {
        List<User> users = Communicator.getUsers();
        users.parallelStream().forEach(user -> {
            printStream.print(user);
        });
    }
}