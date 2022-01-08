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

    borrowBook(id: number) {
        console.log(id);

        this.http
            .post<number>(`/api/user/borrowBook/${id}`, BorrowedBookService.httpOptions())
            .subscribe();
    }

    prolongation(id: number) {
        this.http
            .patch<number>(`/api/user/prolongate/${id}`, BorrowedBookService.httpOptions())
            .subscribe();
    }

    returnBook(id: number) {
        this.http
            .delete<number>(`/api/user/returnBook/${id}`, {
                headers: new HttpHeaders({
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                })
            })
            .subscribe();
    }

    private static httpOptions() {
        return {
            headers: new HttpHeaders({
                Authorization: `Bearer ${localStorage.getItem('token')}`
            })
        };
    }
}
