package ru.netology.domain;

public class Smartphone extends Product {
    private String maker;

    public Smartphone(int id, String name, int cost, String maker){
        super(id, name, cost);
        this.maker = maker;
    }

    public void setMaker(String maker){
        this.maker = maker;
    }

    public String getMaker(){
        return maker;
    }
}
