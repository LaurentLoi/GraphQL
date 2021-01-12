import {UserModel} from './user.model';

export interface BookModel {
  id: number;
  title: string;
  author: string;
  owner: UserModel;
}

export interface BookForm {
    title: string;
    author: string;
    ownerId: number;
}

export type DataBooksModel = {data: {books: BookModel[]}};
