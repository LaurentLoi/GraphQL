import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RootComponent} from './pages/root/root.component';
import {UsersComponent} from './common/components/users/users.component';
import {BooksComponent} from './common/components/books/books.component';
import {BookFormComponent} from './common/forms/book-form/book-form.component';
import {UserFormComponent} from './common/forms/user-form/user-form.component';

const routes: Routes = [
    {
        path: '',
        component: RootComponent,
        children: [
            {
                path: 'users',
                component: UsersComponent
            },
            {
                path: 'users/add',
                component: UserFormComponent
            },
            {
                path: 'books',
                component: BooksComponent
            },
            {
                path: 'books/add',
                component: BookFormComponent
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
