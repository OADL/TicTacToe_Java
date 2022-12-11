package com.example.TicTacToe_Client.Models;

import com.example.TicTacToe_Client.Enums.GameState;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private GameState gameState;
    private List<Move> history;

    public Game(Player playerX, Player playerO) {
        init(playerX,playerO);
    }

    public Game(Player playerX, Player playerO, List<Move> moves) {
        init(playerX,playerO);
        loadGame(moves);
    }

    private void init(Player playerX, Player playerO) {
        board = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
        gameState = GameState.X_TURN;
        history = new ArrayList<>();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public Board getBoard() {
        return board;
    }

    public GameState action(Move move) {
        if(board.isMoveAvailable(move)) {
            history.add(move);
            gameState = board.applyMove(move);
        }
        return gameState;
    }

    private void loadGame(List<Move> moves) {
        for(Move move: moves) {
            action(move);
        }
    }

    public void save(){};

    public void load(){};

    
}
