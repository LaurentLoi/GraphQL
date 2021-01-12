import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {UserForm, UserModel} from '../../models/user.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {GraphqlService} from '../../services/graphql.service';
import {BookForm} from '../../models/book.model';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

    addUserForm: FormGroup;

    constructor(
        private graphqlService: GraphqlService,
        private builder: FormBuilder
    ) {
        this.addUserForm = this.builder.group({
            username: ['', Validators.required],
            password: ['', Validators.required],
            email: ['']
        });
    }

    ngOnInit(): void {
    }

    addUser(): void {
        if (this.addUserForm.valid) {
            console.log(this.addUserForm.getRawValue());
            const newUser: UserForm = {
                username : this.addUserForm.get('username').value,
                password : this.addUserForm.get('password').value
            };
            if (this.addUserForm.get('email').value != null){
                newUser.email = this.addUserForm.get('email').value;
            }
            this.graphqlService.UserMutation(newUser).subscribe(r => console.log(r));
        }
    }
}
