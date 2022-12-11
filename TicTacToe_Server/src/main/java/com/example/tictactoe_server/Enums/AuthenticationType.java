package com.example.tictactoe_server.Enums;

public enum AuthenticationType {
    LOGIN,
    SIGNUP;

    public static AuthenticationType value(String value) {
        for(AuthenticationType type : AuthenticationType.values()){
            if(type.toString().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
