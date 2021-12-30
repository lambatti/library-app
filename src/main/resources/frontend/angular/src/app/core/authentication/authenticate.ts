import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface IUserLogin {
    token: string;
}

@Injectable()
export class Authenticate {
    private baseUrl: string;

    constructor(private http: HttpClient) {
        this.baseUrl = 'http://localhost:8080/api/login';
    }

    authenticate(email: string, password: string): Observable<IUserLogin> {
        console.log(email, password);
        return this.http.post<IUserLogin>(this.baseUrl, {
            email: email,
            password: password
        });
    }
}
