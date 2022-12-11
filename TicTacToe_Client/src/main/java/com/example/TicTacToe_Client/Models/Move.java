package com.example.TicTacToe_Client.Models;

import com.example.TicTacToe_Client.Configs.Constants;
import com.example.TicTacToe_Client.Configs.Utils;
import com.example.TicTacToe_Client.Enums.Shape;
import com.example.TicTacToe_Client.Exceptions.InvalidMoveException;


public class Move {
    private int index;
    private Shape shape;

    public Move(int index, Shape shape) throws InvalidMoveException {
        if(index < Constants.BOARD_FIRST_BORDER || index > Constants.BOARD_LAST_BORDER || Utils.isNull(shape)) throw new InvalidMoveException();
        this.index = index;
        this.shape = shape;
    }

    public int getIndex() {
        return index;
    }

    public Shape getShape() {
        return shape;
    }
}
