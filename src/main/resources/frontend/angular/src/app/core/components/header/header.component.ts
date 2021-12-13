import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'appHeader',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    constructor(private router: Router) {}

    public isActive: boolean = false;
    public isHome: boolean = true;
    public isLoggedIn: boolean = true;
    public user: string = 'kamil';

    navigationSelect(location: string) {
        this.router.navigateByUrl(`/${location}`);
    }
}
