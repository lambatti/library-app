import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book, BorrowedBook } from '../../model/book/book.model';

@Injectable()
export class BorrowedBookService {
    constructor(private http: HttpClient) {}

    getBorrowedBooks(): Observable<Array<BorrowedBook>> {
        return this.http.get<Array<Book>>('/api/user/books', BorrowedBookService.httpOptions());
    }

    borrowBook(id: number): Observable<number> {
        return this.http.post<number>(
            '/api/user/borrowBook',
            id,
            BorrowedBookService.httpOptions()
        );
    }

    prolongation(id: number): Observable<number> {
        return this.http.patch<number>(
            '/api/user/prolongate',
            id,
            BorrowedBookService.httpOptions()
        );
    }

    returnBook(id: number): Observable<number> {
        return this.http.post<number>(
            '/api/user/returnBook',
            id,
            BorrowedBookService.httpOptions()
        );
    }

    private static httpOptions() {
        return {
            headers: new HttpHeaders({
                Authorization: `Bearer ${localStorage.getItem('token')}`
            })
        };
    }
}
