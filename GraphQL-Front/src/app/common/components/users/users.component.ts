import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {UserModel} from '../../models/user.model';
import {GraphqlService} from '../../services/graphql.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  public users$: Observable<UserModel[]>;

  constructor(
    private graphqlService: GraphqlService
  ) {
  }

  ngOnInit(): void {
    this.users$ = this.graphqlService.UsersQuery();
  }

}
