import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BorrowedBook } from '../../model/book/book.model';
import { Router } from '@angular/router';

@Injectable()
export class BorrowedBookService {
    constructor(private http: HttpClient, private router: Router) {}

    getBorrowedBooks(): Observable<Array<BorrowedBook>> {
        return this.http.get<Array<BorrowedBook>>(
            '/api/user/books',
            BorrowedBookService.httpOptions()
        );
    }

    borrowBook(id: number) {
        console.log(id);

        this.http
            .post<number>(`/api/user/borrowBook/${id}`, null, BorrowedBookService.httpOptions())
            .subscribe(() => {
                this.router.navigateByUrl('/');
            });
    }

    prolongation(id: number) {
        this.http
            .patch<number>(`/api/user/prolongate/${id}`, null, BorrowedBookService.httpOptions())
            .subscribe(() => {
                this.router.navigateByUrl('/');
            });
    }

    returnBook(id: number) {
        this.http
            .delete<number>(`/api/user/returnBook/${id}`, {
                headers: new HttpHeaders({
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                })
            })
            .subscribe(() => {
                this.router.navigateByUrl('/');
            });
    }

    private static httpOptions() {
        return {
            headers: new HttpHeaders({
                Authorization: `Bearer ${localStorage.getItem('token')}`
            })
        };
    }
}
