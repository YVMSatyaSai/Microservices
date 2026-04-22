package com.sai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Car {

    @Id
    private int carNo;
    private String company;
    @ManyToMany
    private List<Driver> drivers;

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo=" + carNo +
                ", company='" + company + '\'' +
                ", drivers=" + drivers +
                '}';
    }
}
