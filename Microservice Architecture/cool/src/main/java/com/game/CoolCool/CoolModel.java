package com.game.CoolCool;

public class CoolModel {

    private Integer id;
    private String name;

    public CoolModel(){}

    public CoolModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(String name){
        this.name= name;
    }
}
