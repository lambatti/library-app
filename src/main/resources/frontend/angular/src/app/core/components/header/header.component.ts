import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AsideService } from '../../services/asideService.service';

@Component({
    selector: 'appHeader',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    @Input() isHide?: boolean;

    constructor(private router: Router, public _asideService: AsideService) {}

    public isLoggedIn: boolean = true;
    public user: string = 'kamil';

    navigationSelect(location: string) {
        this.router.navigateByUrl(`/${location}`);
    }
}
