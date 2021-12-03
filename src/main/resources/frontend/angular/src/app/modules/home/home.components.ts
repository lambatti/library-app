import {Component} from "@angular/core";
import {BookRepository} from "../../model/book/book.repository";
import {Book} from "../../model/book/book.model";



@Component({
    selector: "home",
    templateUrl: "home.components.html",
    styleUrls: ["home.component.scss"]
})
export class HomeComponents {
    public isDisplayedBook: number = null;
    public booksPerPage: number = 10;
    public selectedPage: number = 1;

    constructor(private _repository: BookRepository) {
    }

    get books(): Array<Book> {
        let pageIndex = (this.selectedPage - 1) * this.booksPerPage;
        return this._repository.getBooks().slice(pageIndex, pageIndex + this.booksPerPage);
    }

    changePage(newPage: number) {
        this.selectedPage = newPage;
    }

    get pageNumbers(): Array<number> {
        return Array(Math.ceil(this._repository.getBooks().length / this.booksPerPage)).fill(0).map((x, i) => i + 1)
    }

    getBookId(id: number) {
        if (this.isDisplayedBook !== null && this.isDisplayedBook === id) {
            this.isDisplayedBook = null;
            this.booksPerPage = 10;
        } else if (!this.books.find(b => b.id === id).isAvailable) {
            this.isDisplayedBook = null;
            this.booksPerPage = 10;

        } else {
            this.isDisplayedBook = id;
        }
    }

    get displayedBook(): Book {
        return this.books.find(b => b.id === this.isDisplayedBook);
    }
}
