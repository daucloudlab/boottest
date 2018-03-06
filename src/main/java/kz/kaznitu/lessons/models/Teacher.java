package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String firstName ;
    private String lastName ;
    private int baga ;

    public Teacher(){}

    public Teacher(String firstName, String lastName, int baga) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.baga = baga;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int  getBaga() {
        return baga;
    }

    public void setBaga(int baga) {
        this.baga = baga;
    }
}
