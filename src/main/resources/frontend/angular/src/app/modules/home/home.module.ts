import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {ModelModule} from "../../model/book/model.module";
import {HomeComponent} from "./home.components";



@NgModule({
    imports: [ModelModule, BrowserModule, FormsModule],
    declarations: [HomeComponent],
    exports: [HomeComponent]
})
export class HomeModule {}
