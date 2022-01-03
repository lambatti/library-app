import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserRegister } from '../../model/user/user.model';
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
}
