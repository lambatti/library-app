import { NgModule } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { Authenticate } from './authenticate';

@NgModule({
    providers: [AuthenticationService, Authenticate]
})
export class AuthenticateModule {}
