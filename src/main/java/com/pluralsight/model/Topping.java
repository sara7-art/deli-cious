package com.pluralsight.model;

public class Topping {
    // DATA FIELD //
    private String name;
    private String type;
    private boolean premium;
    private boolean extra;


    public Topping(String name, String type, boolean premium, boolean extra) {
        this.name = name;
        this.type = type;
        this.premium = premium;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isExtra() {
        return extra;
    }
}
