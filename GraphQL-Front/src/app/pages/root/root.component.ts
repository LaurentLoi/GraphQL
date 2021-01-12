import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {filter} from 'rxjs/operators';
import {DataUsersModel, UserModel} from '../../common/models/user.model';
import {GraphqlService} from '../../common/services/graphql.service';
import {BookModel} from '../../common/models/book.model';

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {

  }

}
