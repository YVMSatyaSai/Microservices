package com.sai;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToManyClass {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Driver.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Car car = new Car();
        Driver driver = new Driver();

        driver.setDriverName("Ramu");
        driver.setAge(23);

        car.setCarNo(1023);
        car.setCompany("Tata");
        car.setDrivers(Arrays.asList(driver));

        session.persist(driver);
        session.persist(car);

        transaction.commit();
        session.close();
        sf.close();


    }
}