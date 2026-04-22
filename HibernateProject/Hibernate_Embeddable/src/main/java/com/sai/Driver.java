package com.sai;

import jakarta.persistence.Embeddable;

@Embeddable
public class Driver {

    private String driverName;
    private int age;

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

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", age=" + age +
                '}';
    }
}
