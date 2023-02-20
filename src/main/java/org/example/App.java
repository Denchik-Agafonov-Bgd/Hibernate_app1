package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.People;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(People.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            People people = new People("Test people", 20);

            Passport passport = new Passport(1234);

            people.setPassport(passport);

            session.save(people);



            ///////////////

            /*Person person = session.get(Person.class, 3);
            System.out.println(person);

            List<Item> items = person.getItems();

            System.out.println(items);*/

            //////////////

            /*Item item = session.get(Item.class, 5);
            System.out.println(item);

            Person people = item.getOwner();
            System.out.println(people);*/

            //////////////

            /*Person person = session.get(Person.class, 2);
            Item newItem = new Item("Item from Hibernate", person);

            person.getItems().add(newItem);

            session.save(newItem);*/

            //////////////

            /*Person person = new Person("Test person", 10);
            Item newItem = new Item("Item from Hibernate 2", person);

            person.setItems(new ArrayList<Item>(Collections.singletonList(newItem)));

            session.save(person);
            session.save(newItem);*/

            ////////////////////////

           /* Person person = session.get(Person.class, 2);

            session.remove(person);

            person.getItems().forEach(i -> i.setOwner(null));*/

            ////////////////////////

            /*Person person = session.get(Person.class, 2);
            Item item = session.get(Item.class, 1);

            item.getOwner().getItems().remove(item);

            item.setOwner(person);

            person.getItems().add(item);*/

            /////////////


            /*List<Person> people = session.createQuery("FROM Person WHERE age > 30").getResultList();

            session.createQuery("update Person set name='Danil' where age < 30").
                    executeUpdate();

            session.createQuery("delete from Person where age < 30").
                    executeUpdate();

            for (Person person : people)
                System.out.println(person);*/

            /*Person person = session.get(Person.class, 2);
            person.setName("Sasha");*/

            /*Person person1 = new Person("Test1", 30);
            Person person2 = new Person("Test2", 40);
            Person person3 = new Person("Test3", 50);

            session.save(person1);
            session.save(person2);
            session.save(person3);*/

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
