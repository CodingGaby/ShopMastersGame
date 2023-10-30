package com.mycompany;

public class Player {
    private String name;
    private Shop shop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Player(String name){
        this.name = name;
    }
}
