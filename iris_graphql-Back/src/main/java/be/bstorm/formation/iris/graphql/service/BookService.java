package be.bstorm.formation.iris.graphql.service;

import be.bstorm.formation.iris.graphql.model.entity.Book;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Optional<Book> findById(Long id);
    Book newBook(Book book);
}
