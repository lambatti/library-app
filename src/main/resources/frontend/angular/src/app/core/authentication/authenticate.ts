import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ILoginToken {
    token: string;
}

@Injectable()
export class Authenticate {
    private readonly baseUrl: string;

    constructor(private http: HttpClient) {
        this.baseUrl = 'https://arch-library.herokuapp.com/api/';
    }

    authenticate(email: string, password: string): Observable<ILoginToken> {
        return this.http.post<ILoginToken>(this.baseUrl + 'login', {
            email: email,
            password: password
        });
    }
}
