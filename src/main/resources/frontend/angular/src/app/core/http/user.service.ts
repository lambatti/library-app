import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {
    ChangePassword,
    ChangeQuestion,
    Question,
    User,
    UserRegister
} from '../../model/user/user.model';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) {}

    // /api/register
    register(data: UserRegister) {
        this.http.post('', data);
    }

    // /api/user/changePassword
    changePassword(data: ChangePassword) {
        this.http.post('', data, UserService.httpOptions());
    }

    // /api/user/changeQuestion
    changeQuestion(data: ChangeQuestion) {
        this.http.post('', data, UserService.httpOptions());
    }

    // /api/question
    getQuestionRegister(): Observable<Array<Question>> {
        return this.http.get<Array<Question>>('');
    }

    // get /api/user/summary
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
