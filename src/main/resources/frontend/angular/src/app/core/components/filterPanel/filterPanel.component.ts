import { Component } from '@angular/core';
import { BookRepository } from '../../../model/book/book.repository';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../../../model/book/book.model';
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

    getGenre(): string[] {
        return this._service.getGenre();
    }

    filterByGenre(): Book[] {
        return this._service.getBooks().filter(b => this.genre === null || this.genre === b.genre);
    }
}
