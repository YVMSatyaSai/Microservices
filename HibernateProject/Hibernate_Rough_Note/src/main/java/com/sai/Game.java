package com.sai;

import jakarta.persistence.*;

import java.util.List;

//@Embeddable
@Table //(name = "Game1")
@Entity //(name = "Game2")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int g_id;

    @Column(name = "g_name")
    private String names;

    @Transient
    private String description;

//    @ManyToOne // in existing table it will map the reference.
//    private Students students;

    @ManyToMany(mappedBy = "game")
    private List<Students> students;


    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public String toString() {
//        return "Game{" +
//                "g_id=" + g_id +
//                ", names='" + names + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }

//    public Students getStudents() {
//        return students;
//    }
//
//    public void setStudents(Students students) {
//        this.students = students;
//    }


    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Game{" +
                "g_id=" + g_id +
                ", names='" + names + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                '}';
    }
}

