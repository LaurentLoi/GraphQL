package be.bstorm.formation.iris.graphql.resolver.mutation;

import be.bstorm.formation.iris.graphql.model.entity.Book;
import be.bstorm.formation.iris.graphql.model.entity.User;
import be.bstorm.formation.iris.graphql.model.input.UserInput;
import be.bstorm.formation.iris.graphql.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {
    private final UserService userService;

    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    public User newUser(UserInput user) {
        User newUser = new User(user.getUsername(), user.getEmail(), user.getEmail());

        return this.userService.newUser(newUser);
    }

    public User updateUser(Long id, Book book) {
        return this.userService.updateUser(id, book);
    }
}
