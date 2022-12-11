package com.example.TicTacToe_Client.Controllers;

import com.example.TicTacToe_Client.Configs.Constants;
import com.example.TicTacToe_Client.Configs.Utils;
import com.example.TicTacToe_Client.Enums.GameState;
import com.example.TicTacToe_Client.Enums.Shape;
import com.example.TicTacToe_Client.Exceptions.InvalidMoveException;
import com.example.TicTacToe_Client.Models.Game;
import com.example.TicTacToe_Client.Models.Move;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.io.IOException;

public class GameController {
    private Game game;
    @FXML
    Pane square0, square1, square2, square3, square4, square5, square6, square7, square8;
    @FXML
    Pane X0,X1,X2,X3,X4,X5,X6,X7,X8;
    @FXML
    Pane O0,O1,O2,O3,O4,O5,O6,O7,O8;
    @FXML
    Label playerXName,playerOName,gameState;
    @FXML
    Button restartButton;
    @FXML
    Line winRow1, winRow2, winRow3, winCol1, winCol2, winCol3, winDiagLeft, winDiagRight;

    public void setGame(Game game) {
        this.game = game;
        this.playerXName.setText(game.getPlayerX().getName());
        this.playerOName.setText(game.getPlayerO().getName());
        this.gameState.setText(game.getGameState().getValue());
    }

    @FXML
    protected void returnToMainMenu(ActionEvent event) throws IOException {
        Utils.gotoScene(event, Constants.MAIN_MENU_VIEW);
    }

    @FXML
    protected void squareSelected(MouseEvent event) {
        try {
            if (game.getGameState() == GameState.X_TURN || game.getGameState() == GameState.O_TURN) {
                Pane selected = (Pane) event.getSource();
                int square = Integer.parseInt((String) selected.getUserData());
                Shape shape = (game.getGameState() == GameState.X_TURN) ? Shape.X : Shape.O;
                Move move = new Move(square, shape);
                Pane pane = getPaneFromMove(move);
                if(Utils.isNotNull(pane)) {
                    pane.setVisible(true);
                    selected.setDisable(true);
                    GameState newState = game.action(move);
                    this.gameState.setText(newState.getValue());
                    if(newState == GameState.X_WINS || newState == GameState.O_WINS || newState == GameState.DRAW){
                        restartButton.setVisible(true);
                    }
                }
            }
        } catch (InvalidMoveException ignored) {}
    }

    @FXML
    protected void restartGame() {
        this.game = new Game(this.game.getPlayerX(), this.game.getPlayerO());
        resetView();
    }

    private void resetView() {
        playerXName.setText(this.game.getPlayerX().getName());
        playerOName.setText(this.game.getPlayerO().getName());
        gameState.setText(this.game.getGameState().getValue());
        X0.setVisible(false);
        X1.setVisible(false);
        X2.setVisible(false);
        X3.setVisible(false);
        X4.setVisible(false);
        X5.setVisible(false);
        X6.setVisible(false);
        X7.setVisible(false);
        X8.setVisible(false);
        O0.setVisible(false);
        O1.setVisible(false);
        O2.setVisible(false);
        O3.setVisible(false);
        O4.setVisible(false);
        O5.setVisible(false);
        O6.setVisible(false);
        O7.setVisible(false);
        O8.setVisible(false);
        square0.setDisable(false);
        square1.setDisable(false);
        square2.setDisable(false);
        square3.setDisable(false);
        square4.setDisable(false);
        square5.setDisable(false);
        square6.setDisable(false);
        square7.setDisable(false);
        square8.setDisable(false);
        restartButton.setVisible(false);
    }
    private Pane getPaneFromMove(Move move) {
        switch (move.getShape()) {
            case X:
                if(move.getIndex() == 0) return X0;
                if(move.getIndex() == 1) return X1;
                if(move.getIndex() == 2) return X2;
                if(move.getIndex() == 3) return X3;
                if(move.getIndex() == 4) return X4;
                if(move.getIndex() == 5) return X5;
                if(move.getIndex() == 6) return X6;
                if(move.getIndex() == 7) return X7;
                if(move.getIndex() == 8) return X8;
                break;
            case O:
                if(move.getIndex() == 0) return O0;
                if(move.getIndex() == 1) return O1;
                if(move.getIndex() == 2) return O2;
                if(move.getIndex() == 3) return O3;
                if(move.getIndex() == 4) return O4;
                if(move.getIndex() == 5) return O5;
                if(move.getIndex() == 6) return O6;
                if(move.getIndex() == 7) return O7;
                if(move.getIndex() == 8) return O8;
                break;
        }
        return null;
    }
}
