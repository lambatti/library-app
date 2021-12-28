import { NgModule } from '@angular/core';
import { BorrowedBookService } from './borrowedBook.service';
import { BookService } from './book.service';
import { UserService } from './user.service';

@NgModule({
    providers: [BorrowedBookService, BookService, UserService]
})
export class HttpModule {}
