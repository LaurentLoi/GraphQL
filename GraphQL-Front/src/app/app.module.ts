import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { RootComponent } from './pages/root/root.component';
import {RouterModule} from '@angular/router';
import { NavComponent } from './common/components/nav/nav.component';
import { UsersComponent } from './common/components/users/users.component';
import { BooksComponent } from './common/components/books/books.component';
import { BookFormComponent } from './common/forms/book-form/book-form.component';
import {ReactiveFormsModule} from '@angular/forms';
import { UserFormComponent } from './common/forms/user-form/user-form.component';

@NgModule({
  declarations: [
    AppComponent,
    RootComponent,
    NavComponent,
    UsersComponent,
    BooksComponent,
    BookFormComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
