package com.example.TicTacToe_Client;

import com.example.TicTacToe_Client.Configs.Constants;
import com.example.TicTacToe_Client.Configs.Utils;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Utils.gotoScene(stage, Constants.MAIN_MENU_VIEW);
        stage.getIcons().add(new Image(GameApplication.class.getResourceAsStream(Constants.ICON_PATH)));
        stage.setTitle(Constants.WINDOW_TITLE);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}