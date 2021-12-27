import { Component } from '@angular/core';
import { BookRepository } from '../../model/book/book.repository';

@Component({
    selector: 'appMyBooks',
    templateUrl: 'myBooks.component.html',
    styleUrls: ['myBooks.component.scss']
})
export class MyBooksComponent {
    constructor(private repository: BookRepository) {}

    get books(): number[] {
        return this.repository.getBorrowedBooks().map(i => i.id);
    }
}
