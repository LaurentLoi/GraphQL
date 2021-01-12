package be.bstorm.formation.iris.graphql.resolver.mutation;

import be.bstorm.formation.iris.graphql.model.entity.Book;
import be.bstorm.formation.iris.graphql.model.entity.User;
import be.bstorm.formation.iris.graphql.model.input.BookInput;
import be.bstorm.formation.iris.graphql.service.BookService;
import be.bstorm.formation.iris.graphql.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {
    private final BookService bookService;
    private final UserService userService;

    public BookMutationResolver(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public Book newBook(BookInput book) {
        Book newBook = new Book(book.getTitle(), book.getAuthor(), userService.findById(book.getOwnerId()).orElse(null));
        Book savedBook = this.bookService.newBook(newBook);
        if (book.getOwnerId() != null) {
            this.userService.updateUser(book.getOwnerId(), savedBook);
        }
        return savedBook;
    }
}
