package com.example.tictactoe_server.Controllers;

import com.example.tictactoe_server.Services.Communicator;
import com.example.tictactoe_server.Services.Lobby;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MainController {

    private boolean started = false;
    @FXML
    Button startStopButton;
    @FXML
    Label usersCount;

    private final Lobby lobby = new Lobby();

    private Thread updateUsersCount;

    @FXML
    protected void startStop() {
        if(started){
            stop();
        }else{
            start();
        }
    }

    private void stop() {
        started = false;
        lobby.interrupt();
        updateButton("start", Color.DARKGREEN, "LightGreen");
        updateUsersCount.interrupt();
        usersCount.setText("0");
    }

    private void start() {
        started = true;
        lobby.start();
        updateButton("stop", Color.DARKRED, "Pink");
        updateUsersCount = new Thread(() -> {
            while (true) {
                usersCount.setText(String.valueOf(Communicator.getUserCount()));
            }
        });
        updateUsersCount.start();
    }

    private void updateButton(String text, Color textColor, String backGroundColor) {
        startStopButton.setText(text);
        startStopButton.setTextFill(textColor);
        startStopButton.setStyle("-fx-background-color: "+backGroundColor);
    }

}
