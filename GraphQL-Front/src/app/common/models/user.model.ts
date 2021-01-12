import {BookModel} from './book.model';

export interface UserModel {
  id: number;
  username: string;
  email?: string;
  books: [BookModel];
}

// export interface DataModel {
//   data: {users: UserModel[] };
// }

export interface UserForm {
    username: string;
    password: string;
    email?: string;
}

export type DataUsersModel = {data: {users: UserModel[]}};
