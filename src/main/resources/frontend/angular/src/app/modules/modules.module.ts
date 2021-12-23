import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ModelModule } from '../model/model.module';
import { HomeComponent } from './home/home.components';
import { RouterModule } from '@angular/router';
import { CurrentBookComponent } from './currentBook/currentBook.component';
import { AccountComponent } from './account/account.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MyBooksComponent } from './myBooks/myBooks.component';
import { ComponentsModule } from '../core/components/components.module';

@NgModule({
    imports: [ModelModule, BrowserModule, FormsModule, RouterModule, ComponentsModule],
    declarations: [
        HomeComponent,
        CurrentBookComponent,
        AccountComponent,
        LoginComponent,
        RegisterComponent,
        MyBooksComponent
    ],
    exports: [HomeComponent]
})
export class ModulesModule {}
