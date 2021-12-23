import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookRepository } from '../../model/book/book.repository';
import { Book } from '../../model/book/book.model';

@Component({
    selector: 'appCurrentBook',
    templateUrl: 'currentBook.component.html',
    styleUrls: ['currentBook.component.scss']
})
export class CurrentBookComponent {
    private id: number;

    constructor(private _service: BookRepository, activateRoute: ActivatedRoute) {
        this.id = Number(activateRoute.snapshot.params['id']);
    }

    get currentBook(): Book {
        return this._service.getBookById(this.id);
    }
}
