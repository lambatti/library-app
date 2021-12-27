import { Injectable } from '@angular/core';
import { Authenticate } from './authenticate';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class AuthenticationService {
    constructor(private auth: Authenticate, private router: Router) {}

    authenticate(email: string, password: string): Observable<boolean> {
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