package com.freelance.model;

public enum CategoryType {
    DEV("Development & IT"),
    DESIGN("Design & Creative"),
    FINANCE("Finance & Accounting"),
    ADMIN("Admin & Customer"),
    ENGINEERING("Engineering & Architecture"),
    LEGAL("Legal"),
    SALES("Sales & Marketing"),
    WRITING("Writing & Translation");

    public final String type;

    CategoryType(String type) {
        this.type = type;
    }
}
