package com.example.TicTacToe_Client.Enums;

public enum GameState {
    X_WINS ("X Wins"),
    O_WINS ("O Wins"),
    DRAW ("Daw"),
    X_TURN ("X Turn"),
    O_TURN ("O Turn");

    private final String value;

    GameState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}