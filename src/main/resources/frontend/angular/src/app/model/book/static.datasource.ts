import { Injectable } from '@angular/core';
import { Book } from './book.model';
import { from, Observable } from 'rxjs';

@Injectable()
export class StaticDataSource {
    private books: Array<Book> = [
        new Book(
            1,
            'https://picsum.photos/id/10/200/250',
            'Książka',
            'Roman Witek',
            '11-11-2011',
            'Naukowa',
            true,
            12,
            true,
            `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.`
        ),
        new Book(
            2,
            'https://picsum.photos/id/27/200/300',
            'Tomki na froncie',
            'Tomasz Comasz',
            '10-01-2011',
            'Podróżnicza',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            3,
            'https://picsum.photos/id/37/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Biografia',
            false,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            4,
            'https://picsum.photos/id/7/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Biografia',
            false,
            0,
            false,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            5,
            'https://picsum.photos/id/222/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Szkolna',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            6,
            'https://picsum.photos/id/1002/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Inna',
            false,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            7,
            'https://picsum.photos/id/1015/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            8,
            'https://picsum.photos/id/102/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            false,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            9,
            'https://picsum.photos/id/4/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            10,
            'https://picsum.photos/id/5/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            11,
            'https://picsum.photos/id/10/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            12,
            'https://picsum.photos/id/22/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            13,
            'https://picsum.photos/id/21/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            14,
            'https://picsum.photos/id/23/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            15,
            'https://picsum.photos/id/45/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            16,
            'https://picsum.photos/id/46/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            17,
            'https://picsum.photos/id/67/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        )
    ];
    private borrowedBooks: Array<Book> = [
        new Book(
            17,
            'https://picsum.photos/id/67/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,

            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            16,
            'https://picsum.photos/id/46/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        ),
        new Book(
            10,
            'https://picsum.photos/id/5/200/300',
            'Książka',
            'Tomasz Comasz',
            '10-01-2011',
            'Naukowa',
            true,
            2,
            true,
            'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        )
    ];

    getBooks(): Observable<Array<Book>> {
        return from([this.books]);
    }

    getBorrowedBooks(): Observable<Array<Book>> {
        return from([this.borrowedBooks]);
    }
}
