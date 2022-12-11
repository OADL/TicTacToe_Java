package com.example.TicTacToe_Client.Controllers;

import com.example.TicTacToe_Client.Configs.Constants;
import com.example.TicTacToe_Client.Configs.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainMenuController {

    @FXML
    protected void goToMultiPlayer(ActionEvent event) throws IOException {
        Utils.gotoScene(event, Constants.MULTIPLAYER_SETUP_VIEW);
    }
}
