package com.example.TicTacToe_Client.Models;

import com.example.TicTacToe_Client.Configs.Constants;
import com.example.TicTacToe_Client.Configs.Utils;
import com.example.TicTacToe_Client.Enums.GameState;
import com.example.TicTacToe_Client.Enums.Shape;

import java.util.Arrays;

public class Board {
    private Shape[] squares;

    public Board() {
        this.squares = new Shape[Constants.BOARD_WIDTH];
    }

    public boolean isMoveAvailable(Move move) {
        return Utils.isNull(squares[move.getIndex()]);
    }

    public GameState applyMove(Move move) {
        squares[move.getIndex()] = move.getShape();
        return calculateGameState(move);
    }

    private GameState calculateGameState(Move move) {
        if(isWin(move.getShape())) {
            switch (move.getShape()) {
                case X:
                    return GameState.X_WINS;
                case O:
                    return GameState.O_WINS;
            }
        }
        if(isDraw())
            return GameState.DRAW;
        if(move.getShape() == Shape.X)
            return GameState.O_TURN;
        return GameState.X_TURN;
    }

    private boolean isWin(Shape shape) {
        if (squares[0] == shape && squares[1] == shape && squares[2] == shape) { //First Row
            return true;
        } else if (squares[3] == shape && squares[4] == shape && squares[5] == shape) { // Second Row
            return true;
        } else if (squares[6] == shape && squares[7] == shape && squares[8] == shape) { // Third Row
            return true;
        } else if (squares[0] == shape && squares[3] == shape && squares[6] == shape) { // First Column
            return true;
        } else if (squares[1] == shape && squares[4] == shape && squares[7] == shape) { // Second Column
            return true;
        } else if (squares[2] == shape && squares[5] == shape && squares[8] == shape) { // Third Column
            return true;
        } else if (squares[0] == shape && squares[4] == shape && squares[8] == shape) { // Diagonal Right
            return true;
        } else if (squares[2] == shape && squares[4] == shape && squares[6] == shape) { // Diagonal Left
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        return Arrays.stream(squares).noneMatch(Utils::isNull);
    }
}
