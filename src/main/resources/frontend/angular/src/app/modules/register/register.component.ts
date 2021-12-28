import { Component } from '@angular/core';
import { UserRegister } from '../../model/user/user.model';
import { RegisterFormGroup } from '../../core/validators/registerForm.model';

@Component({
    selector: 'appRegisterPage',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
    formGroup: RegisterFormGroup = new RegisterFormGroup();
    public questions: Array<string> = [
        'Czy masz kota?',
        'Czy lubisz chodzić na studia?',
        'Jaki jest twój ulubiony przedmiot?'
    ];

    newUser: UserRegister = new UserRegister();
    formSubmitted: boolean = false;

    addUser(u: UserRegister) {
        console.log(`Nowy user ${JSON.stringify(u)}`);
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
