import { Component, OnInit } from '@angular/core';
import { BookRepository } from '../../model/book/book.repository';
import { BorrowedBook } from '../../model/book/book.model';
import { BorrowedBookService } from '../../core/http/borrowedBook.service';

@Component({
    selector: 'appMyBooks',
    templateUrl: 'myBooks.component.html',
    styleUrls: ['myBooks.component.scss', '../../core/components/bookCard/bookCard.component.scss']
})
export class MyBooksComponent implements OnInit {
    private newBorrowedBook: Array<BorrowedBook> = [];

    constructor(
        private repository: BookRepository,
        private _borrowedBookService: BorrowedBookService
    ) {}

    ngOnInit() {
        this._borrowedBookService.getBorrowedBooks().subscribe(data => {
            this.newBorrowedBook = data;
            console.log('fdkjlsgklfdsa');
        });
    }

    books(): Array<BorrowedBook> {
        return this.newBorrowedBook;
    }

    prolongation(bookId: number) {
        this._borrowedBookService.prolongation(bookId);
    }

    returnBook(bookId: number) {
        this._borrowedBookService.returnBook(bookId);
    }
}
