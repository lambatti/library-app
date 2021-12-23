import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AsideService } from '../../services/asideService.service';

@Component({
    selector: 'appHeader',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    constructor(private router: Router, public _asideService: AsideService) {}

    public isHome: boolean = true;
    public isLoggedIn: boolean = false;
    public user: string = 'kamil';

    navigationSelect(location: string) {
        this.router.navigateByUrl(`/${location}`);
    }
}
