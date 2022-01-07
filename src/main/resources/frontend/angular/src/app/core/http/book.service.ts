import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../../model/book/book.model';

@Injectable()
export class BookService {
    constructor(private http: HttpClient) {}

    // /api/books
    getBooks(): Observable<Array<Book>> {
        return this.http.get<Array<Book>>('/api/books');
    }
}
