import { Injectable } from '@angular/core';
import { AuthenticationService } from '../authentication/authentication.service';
import { CanActivate, Router } from '@angular/router';

@Injectable()
export class AuthGuardService implements CanActivate {
    constructor(private _authenticationService: AuthenticationService, private router: Router) {}

    canActivate(): boolean {
        if (!this._authenticationService.authenticated) {
            this.router.navigateByUrl('/');
            return false;
        }
        return true;
    }
}
