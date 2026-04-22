package com.sai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Driver {

    @Id
    private String driverName;
    private int age;
    @ManyToMany(mappedBy = "drivers")
    private List<Car> cars;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
