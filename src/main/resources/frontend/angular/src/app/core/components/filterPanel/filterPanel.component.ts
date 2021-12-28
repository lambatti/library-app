import { Component } from '@angular/core';
import { BookRepository } from '../../../model/book/book.repository';
import { ActivatedRoute, Router } from '@angular/router';
import { AsideService } from '../../services/asideService.service';

@Component({
    selector: 'appFilter',
    templateUrl: 'filterPanel.component.html',
    styleUrls: ['filterPanel.component.scss']
})
export class FilterPanelComponent {
    public genre: string;

    constructor(
        private _service: BookRepository,
        public _asideService: AsideService,
        private router: Router,
        activateRoute: ActivatedRoute
    ) {
        activateRoute.params.subscribe(params => {
            this.genre = params['genre'] || null;
        });
    }

    errorMessage: boolean;

    //    @Output() bookName = new EventEmitter<string>();

    getGenre(): string[] {
        return this._service.getGenre();
    }

    onEnter(book: string) {
        let newBook = this._service.getBookByName(book);
        if (newBook !== undefined) {
            this.router.navigate(['books', newBook.genre, newBook.id]);
        } else {
            this.errorMessage = true;
        }
    }
}
