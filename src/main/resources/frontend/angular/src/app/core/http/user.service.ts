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
        this.http.post('/api/register', data).subscribe();
    }

    // /api/user/changePassword
    changePassword(data: ChangePassword) {
        this.http.patch('/api/user/changePassword', data, UserService.httpOptions()).subscribe();
    }

    // /api/user/changeQuestion
    changeQuestion(data: ChangeQuestion) {
        this.http.patch('/api/user/changeQuestion', data, UserService.httpOptions()).subscribe();
    }

    // /api/question
    getQuestionRegister(): Observable<Array<Question>> {
        return this.http.get<Array<Question>>('/api/enum/registrationQuestions');
    }

    // get /api/user/summary
    getUserData(): Observable<User> {
        return this.http.get('/api/user/summary', UserService.httpOptions());
    }

    private static httpOptions() {
        return {
            headers: new HttpHeaders({
                Authorization: `Bearer ${localStorage.getItem('token')}`
            })
        };
    }
}
