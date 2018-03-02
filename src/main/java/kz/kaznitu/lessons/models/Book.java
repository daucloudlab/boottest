package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long book_id;
private String book_name;
private String book_genre;
private int years;
private Author author;


public Book() {
  }
    public Book(String book_name, String book_genre, int years) {
    this.book_name = book_name;
    this.book_genre = book_genre;
    this.years = years;
     }

     public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
         this.book_id = book_id;
     }

    public String getBook_name() {
        return book_name;
     }

     public void setBook_name(String book_name) {
         this.book_name = book_name;
        }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }

   public int getYears() {
        return years;
     }

    public void setYears(int years) {
         this.years = years;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}