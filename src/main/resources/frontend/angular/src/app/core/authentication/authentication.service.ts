import { Injectable } from '@angular/core';
import { Authenticate, ILoginToken } from './authenticate';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class AuthenticationService {
    constructor(private auth: Authenticate, private router: Router) {}

    authenticate(email: string, password: string): Observable<ILoginToken> {
        return this.auth.authenticate(email, password);
    }

    get authenticated(): boolean {
        return localStorage.getItem('token') !== null;
    }

    logout() {
        localStorage.removeItem('token');
        this.router.navigateByUrl('/');
    }
}
