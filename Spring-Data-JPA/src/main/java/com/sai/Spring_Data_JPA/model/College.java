package com.sai.Spring_Data_JPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class College {
    @Id
    private int rollno;
    private String name;
    @Column(name="\"group\"")
    private String group;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "College{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
