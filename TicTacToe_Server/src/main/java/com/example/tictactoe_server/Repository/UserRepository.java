package com.example.tictactoe_server.Repository;

import com.example.tictactoe_server.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();

    public static User createUser(User user) {
        user.setId(users.size());
        users.add(user);
        return findByName(user.getName());
    }

    public static User findByName(String name) {
        return users.stream().filter(user1 -> user1.getName().equals(name)).findFirst().orElse(null);
    }
}
