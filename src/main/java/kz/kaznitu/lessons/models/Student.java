package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstName;
    private String lastName;
    private int baga;

    public Student() {
        this.lastName = "" ;
        this.baga = 0 ;
    }

    public Student(String lastName, int baga) {
        this.lastName = lastName;
        this.baga = baga;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBaga() {
        return baga;
    }

    public void setBaga(int baga) {
        this.baga = baga;
    }
}
