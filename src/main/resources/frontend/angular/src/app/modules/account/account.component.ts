import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../model/user/user.model';
import { UserService } from '../../core/http/user.service';

@Component({
    selector: 'appAccountPage',
    templateUrl: 'account.component.html',
    styleUrls: ['account.component.scss']
})
export class AccountComponent {
    public location: string = '';
    public user: User = new User();
    private databaseQuestion: Array<string> = [];

    constructor(public router: Router, public _userService: UserService) {
        _userService.getUserData().subscribe(user => {
            this.user = user;
        });
        this.changeLocation('summary');
        this._userService.getQuestionRegister().subscribe(data => {
            this.databaseQuestion = data;
        });
    }

    public questions: Array<string> =
        this.databaseQuestion.length === 0
            ? [
                  'Czy masz kota?',
                  'Czy lubisz chodzić na studia?',
                  'Jaki jest twój ulubiony przedmiot?'
              ]
            : this.databaseQuestion;

    changeLocation(location: string) {
        this.location = location;
        this.router.navigate(['/account', location]);
    }

    locationTitle(): string {
        if (this.location === 'summary') {
            return 'Moje konto';
        } else if (this.location === 'changeQuestion') {
            return 'Zmiana weryfikacji';
        } else {
            return 'Zmiana hasła';
        }
    }

    get getUserData(): User {
        return this.user;
    }
}
