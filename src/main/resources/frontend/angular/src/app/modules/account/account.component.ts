import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ChangePassword, ChangeQuestion, Question, User } from '../../model/user/user.model';
import { UserService } from '../../core/http/user.service';
import { ChangePasswordGroup, ChangeQuestionGroup } from '../../core/validators/form.model';

@Component({
    selector: 'appAccountPage',
    templateUrl: 'account.component.html',
    styleUrls: ['account.component.scss']
})
export class AccountComponent {
    public location: string = '';
    public user: User = new User();
    databaseQuestion: Array<Question> = [{ key: '', value: '' }];
    changePasswordGroup = new ChangePasswordGroup();
    changeQuestionGroup = new ChangeQuestionGroup();

    constructor(public router: Router, public _userService: UserService) {
        _userService.getUserData().subscribe(user => {
            this.user = user;
        });
        this.changeLocation('summary');
        this._userService.getQuestionRegister().subscribe(data => {
            this.databaseQuestion = data;
        });
    }

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

    newChangePassword: ChangePassword = new ChangePassword();
    formSubmittedPassowrd: boolean = false;

    submitFormChangePassword() {
        Object.keys(this.changePasswordGroup.controls).forEach(
            // @ts-ignore
            c => (this.newChangePassword[c] = this.changePasswordGroup.controls[c].value)
        );
        this.formSubmittedPassowrd = true;
        if (this.changePasswordGroup.valid) {
            console.log(this.newChangePassword);
            this._userService.changePassword(this.newChangePassword);
            this.newChangePassword = new ChangePassword();
            this.changePasswordGroup.reset();
            this.formSubmittedPassowrd = false;
        }
    }

    formSubmittedQuestion: boolean = false;
    newChangeQuestion: ChangeQuestion = new ChangeQuestion();

    submitFormChangeQuestion() {
        Object.keys(this.changeQuestionGroup.controls).forEach(
            // @ts-ignore
            c => (this.newChangeQuestion[c] = this.changeQuestionGroup.controls[c].value)
        );
        this.formSubmittedQuestion = true;
        if (this.changeQuestionGroup.valid) {
            console.log(this.newChangeQuestion);
            this._userService.changeQuestion(this.newChangeQuestion);
            this.newChangeQuestion = new ChangeQuestion();
            this.changePasswordGroup.reset();
            this.formSubmittedQuestion = false;
        }
    }
}
