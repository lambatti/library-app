import { Component } from '@angular/core';

@Component({
    selector: 'appHeader',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    public isActive: boolean = false;
    public isHome: boolean = true;
    public isLoggedIn: boolean = true;
    public user: string = 'kamil';
}
