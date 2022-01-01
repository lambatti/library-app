import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRouting } from './app.routing';
import { AppComponent } from './app.component';
import { ModulesModule } from './modules/modules.module';
import { ModelModule } from './model/model.module';
import { ComponentsModule } from './core/components/components.module';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from './core/http/http.module';
import { FormsModule } from '@angular/forms';
import { AuthenticateModule } from './core/authentication/authenticate.module';
import { AuthGuardService } from './core/guards/authGuard.service';

@NgModule({
    declarations: [AppComponent],
    imports: [
        BrowserModule,
        FormsModule,
        AppRouting,
        ModulesModule,
        ModelModule,
        ComponentsModule,
        HttpModule,
        HttpClientModule,
        AuthenticateModule
    ],
    providers: [AuthGuardService],
    bootstrap: [AppComponent]
})
export class AppModule {}
