import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

interface IUserLogin {
    email: string;
    password: string;
}

@Injectable()
export class Authenticate {
    constructor(private http: HttpClient) {}

    authenticate(email: string, password: string): Observable<boolean> {
        return this.http
            .post<IUserLogin>('', {
                email,
                password
            })
            .pipe(
                map((response: any) => {
                    if (response.success) {
                        localStorage.setItem('token', response.token);
                    }
                    return response.success;
                })
            );
    }
}
