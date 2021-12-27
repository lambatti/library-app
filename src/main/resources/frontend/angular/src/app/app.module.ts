import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRouting } from './app.routing';
import { AppComponent } from './app.component';
import { ModulesModule } from './modules/modules.module';
import { ModelModule } from './model/model.module';
import { ComponentsModule } from './core/components/components.module';
import { HttpClientModule } from '@angular/common/http';
import { BookService } from './core/http/book.service';

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        AppRouting,
        ModulesModule,
        ModelModule,
        ComponentsModule,
        HttpClientModule
    ],
    providers: [BookService],
    bootstrap: [AppComponent]
})
export class AppModule {}
