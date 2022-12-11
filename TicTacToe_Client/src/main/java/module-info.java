module com.example.dummyjavafx {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires lombok;


    opens com.example.TicTacToe_Client.Controllers to javafx.fxml;
    exports com.example.TicTacToe_Client;
}