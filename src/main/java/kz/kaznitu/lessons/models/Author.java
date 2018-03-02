package kz.kaznitu.lessons.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private Set<Book> book;


    public Author(){}

    public Author(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    public Set<Book> getBook() {
        return book;
    }

    public void setBooks(Set<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, firstName='%s', lastName='%a']%n", id, firstName, lastName);
        if (book != null) {
            for(Book book : book) {
                result += String.format("Book[book_id=%d, book_name='%s']%n", book.getBook_id(), book.getBook_name());
            }
        }

        return result;
    }
}
