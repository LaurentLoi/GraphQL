package be.bstorm.formation.iris.graphql.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @ManyToOne(targetEntity = User.class)
    private User owner;

    public Book(){

    }

    public Book(Long id, String title, String author, User owner) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.owner = owner;
    }

    public Book(String title, String author, User owner) {
        this.title = title;
        this.author = author;
        this.owner = owner;

    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(owner, book.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, owner);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
