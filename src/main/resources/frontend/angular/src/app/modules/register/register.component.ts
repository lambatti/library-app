import { Component } from '@angular/core';
import { Question, UserRegister } from '../../model/user/user.model';
import { RegisterFormGroup } from '../../core/validators/form.model';
import { UserService } from '../../core/http/user.service';

@Component({
    selector: 'appRegisterPage',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
    formGroup: RegisterFormGroup = new RegisterFormGroup();
    databaseQuestion: Array<Question> = [];
    modalOpener: boolean = false;

    constructor(private _userService: UserService) {
        this._userService.getQuestionRegister().subscribe(data => {
            this.databaseQuestion = data;
        });
    }

    newUser: UserRegister = new UserRegister();
    formSubmitted: boolean = false;

    addUser(user: UserRegister) {
        this._userService.register(user).subscribe(null, () => {
            console.log('To jest mój błąd');
            this.modalOpener = true;
        });
    }

    submitForm() {
        Object.keys(this.formGroup.controls).forEach(
            // @ts-ignore
            c => (this.newUser[c] = this.formGroup.controls[c].value)
        );
        this.formSubmitted = true;
        console.log(this.newUser);
        if (this.formGroup.valid) {
            this.addUser(this.newUser);
            this.newUser = new UserRegister();
            this.formGroup.reset();
            this.formSubmitted = false;
        }
    }
}
