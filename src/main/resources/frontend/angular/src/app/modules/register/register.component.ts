import { Component } from '@angular/core';

@Component({
    selector: 'appRegisterPage',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
    public questions: Array<string> = [
        'Czy masz kota?',
        'Czy lubisz chodzić na studia?',
        'Jaki jest twój ulubiony przedmiot?'
    ];
}
