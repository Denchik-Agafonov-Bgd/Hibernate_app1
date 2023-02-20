package org.example.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="People")
public class People {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "people")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Passport passport;

    public People() {}

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPeople(this);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", passport=" + passport +
                '}';
    }
}
