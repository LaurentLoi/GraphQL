package be.bstorm.formation.iris.graphql.resolver.query;

import be.bstorm.formation.iris.graphql.model.entity.Book;
import be.bstorm.formation.iris.graphql.model.entity.User;
import be.bstorm.formation.iris.graphql.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookService bookService;

    @Autowired
    public BookQueryResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public Iterable<Book> books() {
        return this.bookService.findAll();
    }

    public Optional<Book> book(Long id) {
        return this.bookService.findById(id);
    }
}
