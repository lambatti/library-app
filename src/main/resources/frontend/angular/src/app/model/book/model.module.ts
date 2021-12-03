import {NgModule} from "@angular/core";
import {BookRepository} from "./book.repository";
import {StaticDataSource} from "./static.datasource";


@NgModule({
    providers: [BookRepository,StaticDataSource]
})
export class ModelModule {}
