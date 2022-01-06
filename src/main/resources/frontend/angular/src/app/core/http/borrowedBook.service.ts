import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../../model/book/book.model';

@Injectable()
export class BorrowedBookService {
    constructor(private http: HttpClient) {}

    getBorrowedBooks(): Observable<Array<Book>> {
        return this.http.get<Array<Book>>('', BorrowedBookService.httpOptions());
    }

    borrowBook(bookId: number): Observable<number> {
        return this.http.post<number>('', { bookId }, BorrowedBookService.httpOptions());
    }

    prolongation(bookId: number): Observable<number> {
        return this.http.patch<number>('', { bookId }, BorrowedBookService.httpOptions());
    }

    returnBook(bookId: number): Observable<number> {
        return this.http.post<number>('', { bookId }, BorrowedBookService.httpOptions());
    }

    private static httpOptions() {
        return {
            headers: new HttpHeaders({
                Authorization: `Bearer ${localStorage.getItem('token')}`
            })
        };
    }
}
