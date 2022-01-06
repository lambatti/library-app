import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User, UserRegister } from '../../model/user/user.model';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    register(data: UserRegister) {
        this.http.post('', data);
    }

    changePassword() {}

    changeQusetion() {}

    changeAnswer() {}

    getQuestionRegister(): Observable<Array<string>> {
        return this.http.get<Array<string>>('');
    }

    // get /api/user/data
    getUserData(): Observable<User> {
        return this.http.get('', UserService.httpOptions());
    }

    private static httpOptions() {
        return {
            headers: new HttpHeaders({
                Authorization: `Bearer ${localStorage.getItem('token')}`
            })
        };
    }
}
