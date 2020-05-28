package Enums;

public enum UserStatus {
    ONLINE("green"),
    OFFLINE("red"),
    IDLE("yellow");


    private final String color;

    UserStatus(String color) {
    this.color = color;
    }

}
