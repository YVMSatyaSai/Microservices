package com.sai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Driver {

    @Id
    private String driverName;
    private int age;
    @ManyToOne
    private Car car;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
