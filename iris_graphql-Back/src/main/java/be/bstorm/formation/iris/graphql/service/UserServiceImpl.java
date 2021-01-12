package be.bstorm.formation.iris.graphql.service;

import be.bstorm.formation.iris.graphql.model.entity.Book;
import be.bstorm.formation.iris.graphql.model.entity.User;
import be.bstorm.formation.iris.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User newUser(User user) {
        return this.userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(Long id, Book book) {
        this.userRepository.findById(id).ifPresent(u -> {
            u.getBooks().add(book);
            this.userRepository.save(u);
        });
        return this.userRepository.getOne(id);
    }
}
