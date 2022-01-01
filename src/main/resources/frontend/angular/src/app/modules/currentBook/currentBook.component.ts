import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookRepository } from '../../model/book/book.repository';
import { Book } from '../../model/book/book.model';
import { AuthenticationService } from '../../core/authentication/authentication.service';

@Component({
    selector: 'appCurrentBook',
    templateUrl: 'currentBook.component.html',
    styleUrls: ['currentBook.component.scss']
})
export class CurrentBookComponent {
    private readonly id: number;

    constructor(
        private _service: BookRepository,
        private _authenticationService: AuthenticationService,
        activateRoute: ActivatedRoute
    ) {
        this.id = Number(activateRoute.snapshot.params['id']);
    }

    isLogged: boolean = this._authenticationService.authenticated;

    get currentBook(): Book {
        return this._service.getBookById(this.id);
    }

    borrowBook() {}
}
