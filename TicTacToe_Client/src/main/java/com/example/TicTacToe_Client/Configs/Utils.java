package com.example.TicTacToe_Client.Configs;

import com.example.TicTacToe_Client.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {
    public static boolean isNull(Object object) {
        return object == null;
    }
    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static void gotoScene(ActionEvent event, String view) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gotoScene(stage, view);
    }

    public static void gotoScene(Stage stage, String view) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        stage.setScene(scene);
    }

    public static void gotoScene(ActionEvent event, Parent pane) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gotoScene(stage, pane);
    }

    public static void gotoScene(Stage stage, Parent pane) throws IOException {
        Scene scene = new Scene(pane, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        stage.setScene(scene);
    }
}
