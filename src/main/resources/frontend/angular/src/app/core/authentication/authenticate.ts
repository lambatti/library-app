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
        this.baseUrl = 'http://localhost:8080/api/';
    }

    authenticate(email: string, password: string): Observable<ILoginToken> {
        console.log(email, password);
        return this.http.post<ILoginToken>(this.baseUrl + 'login', {
            email: email,
            password: password
        });
    }
}
