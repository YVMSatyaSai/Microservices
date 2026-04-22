package com.sai;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Car {

    @Id
    private int carNo;
    private String company;
    @OneToOne
    private Driver driver;

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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo=" + carNo +
                ", company='" + company + '\'' +
                ", driver=" + driver +
                '}';
    }
}
