package com.sai;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Students {

    @Id
    private int rollno;
    private String name;
    private int age;
//    @OneToOne
//    private Game game;
//    @OneToMany // it will create one suppurate table with mapping.
//    @OneToMany(mappedBy = "students") // to avoid creating new table. by saying it will handle by other entity.
//    private List<Game> game;

    @ManyToMany//(mappedBy = "students")
    private List<Game> game;


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
//
//    @Override
//    public String toString() {
//        return "Students{" +
//                "rollno=" + rollno +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", game=" + game +
//                '}';
//    }


    public List<Game> getGame() {
        return game;
    }

    public void setGame(List<Game> game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Students{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", game=" + game +
                '}';
    }
}

