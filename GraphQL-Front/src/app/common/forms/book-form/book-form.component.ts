import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {UserModel} from '../../models/user.model';
import {GraphqlService} from '../../services/graphql.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {BookForm} from '../../models/book.model';

@Component({
    selector: 'app-book-form',
    templateUrl: './book-form.component.html',
    styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {

    users$: Observable<UserModel[]>;

    addBookForm: FormGroup;

    constructor(
        private graphqlService: GraphqlService,
        private builder: FormBuilder
    ) {
        this.addBookForm = this.builder.group({
            title: ['', Validators.required],
            author: ['', Validators.required],
            owner: ['', Validators.required]
        });
    }

    ngOnInit(): void {
        this.users$ = this.graphqlService.UsersQuery();
    }

    addBook(): void {
        if (this.addBookForm.valid) {
            console.log(this.addBookForm.getRawValue());
            const newBook: BookForm = {
                title : this.addBookForm.get('title').value,
                author : this.addBookForm.get('author').value,
                ownerId : parseInt(this.addBookForm.get('owner').value, 10)
            };
            this.graphqlService.BookMutation(newBook).subscribe(r => console.log(r));
        }
    }

}
