package com.example.tictactoe_server.Enums;

public enum Commands {
    LIST_ALL("listAll"),
    CONNECT_TO("connectTo"),
    ACCEPT_CONNECTION("acceptConnection"),
    MOVE("move");

    private final String value;

    Commands(String value) {
        this.value = value;
    }

    public static Commands value(String value) {
        for(Commands command: Commands.values()){
            if(command.value.equalsIgnoreCase(value) || command.name().equalsIgnoreCase(value)) {
                return command;
            }
        }
        return null;
    }
}
