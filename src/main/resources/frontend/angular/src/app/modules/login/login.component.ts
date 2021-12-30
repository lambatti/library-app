import { Component } from '@angular/core';
import { LoginFormGroup } from '../../core/validators/form.model';
import { UserLogin } from '../../model/user/user.model';
import { AuthenticationService } from '../../core/authentication/authentication.service';

@Component({
    selector: 'appLoginPage',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.scss']
})
export class LoginComponent {
    formGroup: LoginFormGroup = new LoginFormGroup();

    constructor(private authenticateService: AuthenticationService) {}

    logIn(user: UserLogin) {
        console.log(user);
        this.authenticateService
            .authenticate(user.email, user.password)
            .subscribe(x => localStorage.setItem('token', x.token));
    }

    loggedUser: UserLogin = new UserLogin();
    formSubmitted: boolean = false;

    submitForm() {
        Object.keys(this.formGroup.controls).forEach(
            // @ts-ignore
            c => (this.loggedUser[c] = this.formGroup.controls[c].value)
        );
        this.formSubmitted = true;
        if (this.formGroup.valid) {
            this.logIn(this.loggedUser);
            this.loggedUser = new UserLogin();
            this.formGroup.reset();
            this.formSubmitted = false;
        }
    }
}
