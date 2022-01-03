import { Component } from '@angular/core';
import { UserRegister } from '../../model/user/user.model';
import { RegisterFormGroup } from '../../core/validators/form.model';
import { UserService } from '../../core/http/user.service';

@Component({
    selector: 'appRegisterPage',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
    formGroup: RegisterFormGroup = new RegisterFormGroup();
    private databaseQusetion: Array<string> = [];

    constructor(private _userService: UserService) {
        this._userService.getQuestionRegister().subscribe(data => {
            this.databaseQusetion = data;
        });
    }

    public questions: Array<string> =
        this.databaseQusetion.length === 0
            ? [
                  'Czy masz kota?',
                  'Czy lubisz chodzić na studia?',
                  'Jaki jest twój ulubiony przedmiot?'
              ]
            : this.databaseQusetion;

    newUser: UserRegister = new UserRegister();
    formSubmitted: boolean = false;

    addUser(user: UserRegister) {
        this._userService.register(user);
    }

    submitForm() {
        Object.keys(this.formGroup.controls).forEach(
            // @ts-ignore
            c => (this.newUser[c] = this.formGroup.controls[c].value)
        );
        this.formSubmitted = true;
        if (this.formGroup.valid) {
            this.addUser(this.newUser);
            this.newUser = new UserRegister();
            this.formGroup.reset();
            this.formSubmitted = false;
        }
    }
}
