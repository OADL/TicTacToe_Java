module com.example.tictactoe_server {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.example.tictactoe_server.Controllers to javafx.fxml;
    exports com.example.tictactoe_server;
    exports com.example.tictactoe_server.Enums;
}