package com.sai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

public class EmbeddableClass {

    public static void main (String args[]){

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.sai.Car.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Car car = new Car();
        Driver driver = new Driver();

        driver.setDriverName("Ramu");
        driver.setAge(23);

        car.setCarNo(1023);
        car.setCompany("Tata");
        car.setDriver(driver);

        Transaction transaction = session.beginTransaction();

        session.persist(car);

        transaction.commit();
        session.close();
        sf.close();

        System.out.println(car);

    }
}
