import { Injectable } from '@angular/core';
import { StaticDataSource } from './static.datasource';
import { Book } from './book.model';

@Injectable()
export class BookRepository {
    private books: Array<Book> = [];
    private authors: Array<string> = [];
    private category: string = '';

    constructor(private _dataSource: StaticDataSource) {
        _dataSource.getBooks().subscribe(data => {
            this.books = data;
            this.authors = data
                .map(a => a.author)
                .filter((c, index, array) => array.indexOf(c) === index)
                .sort();
        });
    }

    getBooks(category: string = null) {
        return this.books.filter(
            b => category === null || b.author === category
        );
    }
    getBookById(id: number) {
        return this.books.find(i => i.id === id);
    }

    getAuthors(): Array<string> {
        return this.authors;
    }
}
