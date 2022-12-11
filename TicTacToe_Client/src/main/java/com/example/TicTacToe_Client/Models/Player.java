package com.example.TicTacToe_Client.Models;

import com.example.TicTacToe_Client.Enums.Shape;

public class Player {
    private String name;
    private Shape shape;

    public Player(String name, Shape shape) {
        this.name = name;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public Shape getShape() {
        return shape;
    }
}
