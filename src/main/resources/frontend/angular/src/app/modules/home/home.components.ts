import { Component, HostListener } from '@angular/core';
import { BookRepository } from '../../model/book/book.repository';
import { Book } from '../../model/book/book.model';
import { ActivatedRoute, Router } from '@angular/router';
import { AsideService } from '../../core/services/asideService.service';

@Component({
    selector: 'appHomePage',
    templateUrl: 'home.components.html',
    styleUrls: ['home.component.scss']
})
export class HomeComponent {
    public selectedPage: number = 1;
    public genre: string;
    public isActive: boolean = true;
    private widthSize: number = window.innerWidth;

    constructor(
        private _repository: BookRepository,
        private router: Router,
        activateRoute: ActivatedRoute,
        private _asideService: AsideService
    ) {
        activateRoute.params.subscribe(params => {
            this.genre = params['genre'] || null;
        });
    }

    get books(): Array<Book> {
        let pageIndex = (this.selectedPage - 1) * this._asideService.breakPoints(this.widthSize);
        console.log(pageIndex);

        return this._repository
            .getBooks()
            .filter(b => this.genre === null || this.genre === b.genre)
            .slice(pageIndex, pageIndex + this._asideService.breakPoints(this.widthSize));
    }

    changePage(newPage: number) {
        this.selectedPage = newPage;
        console.log(window.innerWidth);
    }

    get pageNumbers(): Array<number> {
        return Array(
            Math.ceil(
                this._repository.getBooks().length / this._asideService.breakPoints(this.widthSize)
            )
        )
            .fill(0)
            .map((x, i) => i + 1);
    }

    @HostListener('window:resize', ['$event'])
    onResize(event: any) {
        this.widthSize = event.target.innerWidth;
    }
}
