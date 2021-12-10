import { Component, Input } from '@angular/core';
import { Book } from '../../../model/book/book.model';
import { BookRepository } from '../../../model/book/book.repository';

@Component({
    selector: 'appBookCard',
    templateUrl: 'bookCard.component.html',
    styleUrls: ['bookCard.component.scss']
})
export class BookCardComponent {
    @Input() selectedBook: number;

    constructor(private _repository: BookRepository) {}
    get displayedBook(): Book {
        return this._repository.getBookById(this.selectedBook);
    }
}
