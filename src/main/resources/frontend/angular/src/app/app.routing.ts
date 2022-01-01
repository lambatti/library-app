import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { HomeComponent } from './modules/home/home.components';
import { RegisterComponent } from './modules/register/register.component';
import { MyBooksComponent } from './modules/myBooks/myBooks.component';
import { AccountComponent } from './modules/account/account.component';
import { CurrentBookComponent } from './modules/currentBook/currentBook.component';
import { AuthGuardService as AuthGuard } from './core/guards/authGuard.service';

const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    { path: 'books/:genre/:id', component: CurrentBookComponent },
    { path: 'books/:genre', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'myBooks', component: MyBooksComponent, canActivate: [AuthGuard] },
    { path: 'account', component: AccountComponent, canActivate: [AuthGuard] }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRouting {}
