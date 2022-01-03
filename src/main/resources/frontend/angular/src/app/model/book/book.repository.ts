import { Injectable } from '@angular/core';
import { StaticDataSource } from './static.datasource';
import { Book } from './book.model';
import { BorrowedBookService } from '../../core/http/borrowedBook.service';

@Injectable()
export class BookRepository {
    private books: Array<Book> = [];
    private authors: Array<string> = [];
    private genre: Array<string> = [];
    private borrowedBooks: Array<Book> = [];

    constructor(private _dataSource: StaticDataSource, private _borrowedBook: BorrowedBookService) {
        _dataSource.getBooks().subscribe(data => {
            this.books = data;
            this.authors = data
                .map(a => a.author)
                .filter((c, index, array) => array.indexOf(c) === index)
                .sort();
            this.genre = data
                .map(c => c.genre)
                .filter((c, index, array) => array.indexOf(c) === index)
                .sort();
        });

        // _borrowedBook.getBorrowedBooks().subscribe(data => {
        //     this.borrowedBooks = data;
        // });
        _dataSource.getBorrowedBooks().subscribe(data => {
            this.borrowedBooks = data;
        });
    }

    getBooks(category: string = null) {
        return this.books.filter(b => category === null || b.author === category);
    }

    getBookById(id: number) {
        return this.books.find(i => i.id === id);
    }

    getBookByName(name: string): Book {
        return this.books.find(i => i.name.toLowerCase() === name.toLowerCase());
    }

    getGenre(): Array<string> {
        return this.genre;
    }

    getAuthors(): Array<string> {
        return this.authors;
    }

    getBorrowedBooks() {
        return this.borrowedBooks;
    }
}
