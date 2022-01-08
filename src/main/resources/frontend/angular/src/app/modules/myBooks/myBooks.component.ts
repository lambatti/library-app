import { Component } from '@angular/core';
import { BookRepository } from '../../model/book/book.repository';
import { BorrowedBook } from '../../model/book/book.model';
import { BorrowedBookService } from '../../core/http/borrowedBook.service';

@Component({
    selector: 'appMyBooks',
    templateUrl: 'myBooks.component.html',
    styleUrls: ['myBooks.component.scss', '../../core/components/bookCard/bookCard.component.scss']
})
export class MyBooksComponent {
    constructor(
        private repository: BookRepository,
        private _borrowedBookService: BorrowedBookService
    ) {}

    get books(): Array<BorrowedBook> {
        return this.repository.getBorrowedBooks();
    }

    prolongation(bookId: number) {
        this._borrowedBookService.prolongation(bookId);
    }

    returnBook(bookId: number) {
        this._borrowedBookService.returnBook(bookId);
    }
}
