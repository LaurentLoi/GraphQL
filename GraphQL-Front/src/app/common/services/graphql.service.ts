import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DataUsersModel, UserForm, UserModel} from '../models/user.model';
import {map} from 'rxjs/operators';
import {BookForm, BookModel, DataBooksModel} from '../models/book.model';

@Injectable({
    providedIn: 'root'
})
export class GraphqlService {

    BASE_GRAPHQL_URL = 'http://localhost:8080/graphql';

    constructor(
        private httpClient: HttpClient
    ) {
    }

    UsersQuery(): Observable<Array<UserModel>> {
        return this.httpClient.post<DataUsersModel>(this.BASE_GRAPHQL_URL, {
            query: `query GraphQL{ users { id, username, email, books { id, title, author } } }`
        }).pipe(map(d => d.data.users));
    }

    UserMutation(user: UserForm): Observable<any> {
        console.log(user);
        return this.httpClient.post(this.BASE_GRAPHQL_URL, {
            query: `mutation CreateUser{newUser( user: { username: "${user.username}", email: "${user.email}", password: "${user.password}"}){id,username,email,books {id,title, author}}}`
        });
    }


    BooksQuery(): Observable<Array<BookModel>> {
        return this.httpClient.post<DataBooksModel>(this.BASE_GRAPHQL_URL, {
            query: `query GraphQL{ books { id, title, author, owner { id, username, email } } }`
        }).pipe(map(d => d.data.books));
    }

    BookMutation(book: BookForm): Observable<any> {
        console.log(book);
        return this.httpClient.post(this.BASE_GRAPHQL_URL, {
            query: `mutation CreateBook{newBook( book: { title: "${book.title}", author: "${book.author}", ownerId: ${book.ownerId}}){id,title,author,owner {username,books {title}}}}`
        });
    }
}
