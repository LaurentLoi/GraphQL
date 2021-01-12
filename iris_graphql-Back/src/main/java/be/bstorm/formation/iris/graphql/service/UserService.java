package be.bstorm.formation.iris.graphql.service;

import be.bstorm.formation.iris.graphql.model.entity.Book;
import be.bstorm.formation.iris.graphql.model.entity.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(Long id);

    User newUser(User user);

    User updateUser(Long id, Book book);
}
