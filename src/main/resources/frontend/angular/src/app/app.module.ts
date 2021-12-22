import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRouting } from './app.routing';
import { AppComponent } from './app.component';
import { HomeModule } from './modules/home/home.module';
import { LoginComponent } from './modules/login/login.component';
import { RegisterComponent } from './modules/register/register.component';

@NgModule({
    declarations: [AppComponent, LoginComponent, RegisterComponent],
    imports: [BrowserModule, AppRouting, HomeModule],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {}
