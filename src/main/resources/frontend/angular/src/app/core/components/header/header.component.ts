import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AsideService } from '../../services/asideService.service';
import { AuthenticationService } from '../../authentication/authentication.service';
import { UserService } from '../../http/user.service';

@Component({
    selector: 'appHeader',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    @Input() isHide?: boolean;
    public firstName: string;

    constructor(
        private router: Router,
        public _asideService: AsideService,
        public _authenticationService: AuthenticationService,
        private _userService: UserService
    ) {
        _userService.getUserData().subscribe(user => {
            this.firstName = user.firstName;
        });
    }

    public isLoggedIn: boolean = this._authenticationService.authenticated;

    navigationSelect(location: string) {
        if (location === 'logout') {
            localStorage.removeItem('token');
            this.router.navigateByUrl('/');
        } else {
            this.router.navigateByUrl(`/${location}`);
        }
    }
}
