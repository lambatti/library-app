import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ModelModule } from '../../model/book/model.module';
import { HomeComponent } from './home.components';
import { HeaderComponent } from '../../core/components/header/header.component';
import { FilterPanelComponent } from '../../core/components/filterPanel/filterPanel.component';
import { BookCardComponent } from '../../core/components/bookCard/bookCard.component';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [ModelModule, BrowserModule, FormsModule, RouterModule],
    declarations: [
        HomeComponent,
        HeaderComponent,
        FilterPanelComponent,
        BookCardComponent
    ],
    exports: [HomeComponent]
})
export class HomeModule {}
