package com.example.TicTacToe_Client.Enums;

public enum Shape {
    X ("X"),
    O ("O");

    private final String value;

    Shape(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
