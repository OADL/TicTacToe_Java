package com.example.TicTacToe_Client.Controllers;

import com.example.TicTacToe_Client.Configs.Constants;
import com.example.TicTacToe_Client.Configs.Utils;
import com.example.TicTacToe_Client.Enums.Shape;
import com.example.TicTacToe_Client.GameApplication;
import com.example.TicTacToe_Client.Models.Game;
import com.example.TicTacToe_Client.Models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MultiplayerController {
    @FXML
    TextField nameX;
    @FXML
    TextField nameO;

    @FXML
    protected void returnToMainMenu(ActionEvent event) throws IOException {
        Utils.gotoScene(event, Constants.MAIN_MENU_VIEW);
    }

    @FXML
    protected void startGame(ActionEvent event) throws IOException {
        String nameOfX = (nameX.getText().isEmpty())? "Player X" : nameX.getText();
        String nameOfO = (nameO.getText().isEmpty())? "Player O" : nameO.getText();
        Player playerX = new Player(nameOfX, Shape.X);
        Player playerO = new Player(nameOfO, Shape.O);
        Game game = new Game(playerX, playerO);
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(Constants.GAME_VIEW));
        Parent pane = fxmlLoader.load();
        GameController gameController = fxmlLoader.getController();
        gameController.setGame(game);
        Utils.gotoScene(event,pane);
    }
}
