import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {BookModel} from '../../models/book.model';
import {GraphqlService} from '../../services/graphql.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  public books$: Observable<BookModel[]>;

  constructor(
    private graphqlService: GraphqlService
  ) {
  }

  ngOnInit(): void {
    this.books$ = this.graphqlService.BooksQuery();
  }

}
