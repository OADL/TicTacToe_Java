package com.example.tictactoe_server.Services;

import com.example.tictactoe_server.Models.Client;
import com.example.tictactoe_server.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Communicator {
    private static List<Client> clients = new ArrayList<>();

    public static void addClient (Client client) {
        clients.add(client);
        client.start();
    }

    public static void reset() {
        clients = new ArrayList<>();
    }

    public static int getUserCount() {
        return clients.size();
    }

    public static void disconnectClosed() {
//        for(Client client: clients) {
//            if(!client.isConnected(){
//                clients.remove(client);
//            }
//        }
        clients.removeIf(client -> !client.isConnected());
    }

    public static List<User> getUsers() {
//        List<User> users = new ArrayList<>();
//        for(Client client: clients) {
//            users.add(client.getUser());
//        }
//        return users;
        return clients.stream().map(Client::getUser).collect(Collectors.toList());
    }
}
