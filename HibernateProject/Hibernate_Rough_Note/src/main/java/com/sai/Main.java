package com.sai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Game game = new Game();
//            game.setG_id(1101);
            game.setNames("Cricket");
        Game game1 = new Game();
//            game1.setG_id(1102);
            game1.setNames("swimming");
        Game game2 = new Game();
//            game1.setG_id(1103);
            game2.setNames("running");



//  To insert the values.
        Students students = new Students();
            students.setRollno(101);
            students.setName("sai");
            students.setAge(25);
//            students.setGame(game);
            students.setGame(Arrays.asList(game,game1));

//            game.setStudents(students);
//            game1.setStudents(students);



        Students students1 = new Students();
        students1.setRollno(102);
        students1.setName("Mani");
        students1.setAge(26);
        students1.setGame(Arrays.asList(game1,game2));

        Students students2 = new Students();
        students2.setRollno(103);
        students2.setName("yoga");
        students2.setAge(27);
        students2.setGame(Arrays.asList(game2,game));

        game.setStudents(Arrays.asList(students,students2));
        game1.setStudents(Arrays.asList(students,students1));
        game2.setStudents(Arrays.asList(students1,students2));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.sai.Students.class) // this where sf load entity files.
                .addAnnotatedClass(com.sai.Game.class)
                .configure() // To load the hibernate.cfg.xml file. Where DB configuration happening
                .buildSessionFactory();

        Session session = sf.openSession(); // opening the DB.

//  To save the inserted values in DB.
//        Transaction transaction = session.beginTransaction();
//        session.persist(students);
//        transaction.commit();

//  To save the inserted values in DB.
        Transaction transaction = session.beginTransaction();

        session.persist(game);
        session.persist(game1);
        session.persist(game2);
        session.persist(students);
        session.persist(students1);
        session.persist(students2);

        transaction.commit();

//  To get the values from DB.
//        students = session.get(Students.class,1);

//  To modify the inserted values in DB.
//        Transaction transaction = session.beginTransaction();
//        session.merge(students);
//        transaction.commit();

//  To remove the inserted values in DB.
//        Transaction transaction = session.beginTransaction();
//        session.remove(students);
//        transaction.commit();

        session.close(); // closing the db.
        sf.close(); // closing the sf.

//            System.out.println(students);

        }
    }