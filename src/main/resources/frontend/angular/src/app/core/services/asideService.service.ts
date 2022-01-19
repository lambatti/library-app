import { Injectable } from '@angular/core';

@Injectable()
export class AsideService {
    public isActive: boolean = false;

    public hide() {
        console.log(this.isActive);
        this.isActive = !this.isActive;
    }

    public breakPoints(width: number | null): number {
        if (width >= 1767) {
            return 10;
        }
        if (width >= 1400 || (width >= 934 && width < 992)) {
            return 8;
        }
        if (width >= 1034 || (width >= 689 && width < 934)) {
            return 6;
        }
        if (width >= 992 || (width >= 445 && width < 689)) {
            return 4;
        }

        return 5;
    }
}
