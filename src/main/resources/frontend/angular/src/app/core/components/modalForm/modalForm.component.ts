import { Component, Input } from '@angular/core';

@Component({
    selector: 'appModalForm',
    templateUrl: 'modalForm.component.html',
    styleUrls: ['modalForm.component.scss']
})
export class ModalFormComponent {
    @Input() isOpen: boolean = false;

    changeVisibility(): void {
        this.isOpen = !this.isOpen;
    }
}
