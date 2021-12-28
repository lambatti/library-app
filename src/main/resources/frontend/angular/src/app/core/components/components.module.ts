import { NgModule } from '@angular/core';
import { ModelModule } from '../../model/model.module';
import { BookCardComponent } from './bookCard/bookCard.component';
import { FilterPanelComponent } from './filterPanel/filterPanel.component';
import { HeaderComponent } from './header/header.component';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AsideService } from '../services/asideService.service';
import { AuthenticationService } from '../authentication/authentication.service';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [ModelModule, BrowserModule, RouterModule, FormsModule],
    exports: [FilterPanelComponent, HeaderComponent, BookCardComponent],
    declarations: [BookCardComponent, FilterPanelComponent, HeaderComponent],
    providers: [AsideService, AuthenticationService]
})
export class ComponentsModule {}
