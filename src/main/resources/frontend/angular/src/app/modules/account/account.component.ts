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

    constructor(public router: Router, public _userService: UserService) {
        this.location = 'summary';
        _userService.getUserData().subscribe(user => {
            this.user = user;
        });
    }

    changeLocation(location: string) {
        this.location = location;
        this.router.navigate(['/account', location]);
    }

    get getUserData(): User {
        return this.user;
    }
}
