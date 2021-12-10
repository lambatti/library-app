import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeModule } from './modules/home/home.module';
import { LoginComponent } from './modules/login/login.component';
import { RegisterComponent } from './modules/register/register.component';

@NgModule({
    declarations: [AppComponent, LoginComponent, RegisterComponent],
    imports: [BrowserModule, AppRoutingModule, HomeModule],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {}
