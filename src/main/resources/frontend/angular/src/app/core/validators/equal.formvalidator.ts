import { FormControl } from '@angular/forms';

export class EqualValidator {
    static Equal(equal: any) {
        return (control: FormControl): { [key: string]: any } => {
            if (control.value !== null && control.value === equal) {
                return { equal: { equal: equal, actualValue: control.value } };
            } else {
                return null;
            }
        };
    }
}
