import { Component } from '@angular/core';
import { LoginFormGroup } from '../../core/validators/form.model';
import { UserLogin } from '../../model/user/user.model';
import { AuthenticationService } from '../../core/authentication/authentication.service';
import { Router } from '@angular/router';

@Component({
    selector: 'appLoginPage',
    templateUrl: 'login.component.html',
    styleUrls: ['login.component.scss']
})
export class LoginComponent {
    formGroup: LoginFormGroup = new LoginFormGroup();

    constructor(private authenticateService: AuthenticationService, private router: Router) {}

    logIn(user: UserLogin) {
        this.authenticateService
            .authenticate(user.email, user.password)
            .subscribe(x => localStorage.setItem('token', x.token));
        if (this.authenticateService.authenticated) {
            this.router.navigateByUrl('/');
        }
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
