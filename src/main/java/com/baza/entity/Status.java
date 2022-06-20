package com.baza.entity;

public enum Status {
    PENDING("Pending"), IN_PROGRESS("In progress"), CONNECTED("Connected");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
