package com.example.TicTacToe_Client.Exceptions;

public class InvalidMoveException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid Move: " + super.getMessage();
    }
}
