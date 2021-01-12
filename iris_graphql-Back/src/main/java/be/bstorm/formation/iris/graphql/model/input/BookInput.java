package be.bstorm.formation.iris.graphql.model.input;

import be.bstorm.formation.iris.graphql.model.entity.User;

public class BookInput {

    private String title;
    private String author;
    private Long ownerId;

    public String getTitle() {
        return title;
    }

    public BookInput setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookInput setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwner(Long ownerId) {
        this.ownerId = ownerId;
    }
}
