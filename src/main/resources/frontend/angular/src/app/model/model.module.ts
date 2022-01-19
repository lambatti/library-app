import { NgModule } from '@angular/core';
import { BookRepository } from './book/book.repository';
import { StaticDataSource } from './book/static.datasource';

@NgModule({
    providers: [BookRepository, StaticDataSource]
})
export class ModelModule {}
