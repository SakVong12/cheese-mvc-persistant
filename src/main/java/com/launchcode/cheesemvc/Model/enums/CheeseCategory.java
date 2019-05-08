package com.launchcode.cheesemvc.Model.enums;

public enum CheeseCategory {

    SHREDDED ("Shredded"),
    SLICED ("Sliced"),
    MELTED ("Melted");

    private final String name;

    CheeseCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
