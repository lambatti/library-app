import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { HomeComponent } from './modules/home/home.components';
import { RegisterComponent } from './modules/register/register.component';
import { MyBooksComponent } from './modules/myBooks/myBooks.component';
import { AccountComponent } from './modules/account/account.component';
import { CurrentBookComponent } from './modules/currentBook/currentBook.component';

const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    { path: 'books/:genre/:id', component: CurrentBookComponent },
    { path: 'books/:genre', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'myBooks', component: MyBooksComponent },
    { path: 'account', component: AccountComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRouting {}
