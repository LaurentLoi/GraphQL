package be.bstorm.formation.iris.graphql.resolver.query;

import be.bstorm.formation.iris.graphql.model.entity.User;
import be.bstorm.formation.iris.graphql.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserService userService;

    @Autowired
    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    public Iterable<User> users() {
        return this.userService.findAll();
    }

    public Optional<User> user(Long id) {
        return this.userService.findById(id);
    }
}
