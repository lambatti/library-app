import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../../model/book/book.model';

@Injectable()
export class BorrowedBookService {
    constructor(private http: HttpClient) {}

    getBorrowedBooks(): Observable<Book> {
        return this.http.get('');
    }
}
