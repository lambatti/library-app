import { Component, Input } from '@angular/core';

@Component({
    selector: 'appModalInfo',
    templateUrl: 'modalInfo.component.html',
    styleUrls: ['modalInfo.component.scss']
})
export class ModalInfoComponent {
    @Input() isActive: boolean;
}

}
