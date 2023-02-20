package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Passport")
public class Passport implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private People people;

    @Column(name="passport_number")
    private int passportNumper;

    public Passport(int passportNumper) {
        this.passportNumper = passportNumper;
    }

    public Passport() {

    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public int getPassportNumper() {
        return passportNumper;
    }

    public void setPassportNumper(int passportNumper) {
        this.passportNumper = passportNumper;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "people=" + people +
                ", passportNumper=" + passportNumper +
                '}';
    }
}
