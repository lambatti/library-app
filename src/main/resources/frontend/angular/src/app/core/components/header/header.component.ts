import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AsideService } from '../../services/asideService.service';
import { AuthenticationService } from '../../authentication/authentication.service';

@Component({
    selector: 'appHeader',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    @Input() isHide?: boolean;

    constructor(
        private router: Router,
        public _asideService: AsideService,
        public _authenticationService: AuthenticationService
    ) {}

    public isLoggedIn: boolean = this._authenticationService.authenticated;
    public user: string = 'kamil';

    navigationSelect(location: string) {
        if (location === 'logout') {
            this._authenticationService.logout();
            window.location.reload();
        } else {
            this.router.navigateByUrl(`/${location}`);
        }
    }

    zzz() {
        console.log('siemka');
    }
}
