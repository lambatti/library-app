import { Component, Input } from '@angular/core';
import { Book } from '../../../model/book/book.model';
import { BookRepository } from '../../../model/book/book.repository';
import { BorrowedBookService } from '../../http/borrowedBook.service';

@Component({
    selector: 'appBookCard',
    templateUrl: 'bookCard.component.html',
    styleUrls: ['bookCard.component.scss']
})
export class BookCardComponent {
    @Input() selectedBook?: number;
    @Input() isMyBooks: boolean;
    @Input() isLogged: boolean;

    constructor(
        private _repository: BookRepository,
        private _borrowedBookService: BorrowedBookService
    ) {}

    get displayedBook(): Book {
        return this._repository.getBookById(this.selectedBook);
    }

    prolongation(bookId: number) {
        this._borrowedBookService.prolongation(bookId);
    }

    borrow(bookId: number) {
        this._borrowedBookService.borrowBook(bookId);
    }

    returnBook(bookId: number) {
        this._borrowedBookService.returnBook(bookId);
    }
}
