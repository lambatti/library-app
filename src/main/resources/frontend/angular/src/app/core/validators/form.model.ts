import { FormControl, FormGroup, Validators } from '@angular/forms';

export class CustomFormControl extends FormControl {
    label: string;
    modelProperty: string;

    constructor(label: string, property: string, value: any, validator: any) {
        super(value, validator);
        this.label = label;
        this.modelProperty = property;
    }

    getValidationMessages() {
        let messages: string[] = [];
        if (this.errors) {
            for (let errorName in this.errors) {
                switch (errorName) {
                    case 'required':
                        messages.push(`Proszę podać wartość w polu ${this.label}`);
                        break;
                    case 'minlength':
                        messages.push(
                            `Wymagane jest podanie przynajmniej ${this.errors['minlength'].requiredLength} znaków`
                        );
                        break;
                    case 'maxlength':
                        messages.push(
                            `Wymagane jest podanie maksymalnie ${this.errors['maxlength'].requiredLength} znaków`
                        );
                        break;
                    case 'pattern':
                        messages.push(`Wprowadzone dane zawierają niedozwolone znaki`);
                        break;
                }
            }
        }
        return messages;
    }
}

export class RegisterFormGroup extends FormGroup {
    constructor() {
        super({
            firstName: new CustomFormControl(
                'Imię',
                'firstName',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.pattern('^[A-Z][a-z]+$'),
                    Validators.minLength(3),
                    Validators.maxLength(20)
                ])
            ),

            lastName: new CustomFormControl(
                'Nazwisko',
                'lastName',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(3),
                    Validators.maxLength(50),
                    Validators.pattern('^[A-Z][a-z]+')
                ])
            ),
            email: new CustomFormControl(
                'Email',
                'email',
                '',
                Validators.compose([Validators.required, Validators.email])
            ),
            password: new CustomFormControl(
                'Hasło',
                'password',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            ),
            confimPassword: new CustomFormControl(
                'Potwierdź hasło',
                'confimPassword',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            ),
            gender: new CustomFormControl('Płeć', 'gender', '', Validators.required),
            birthDate: new CustomFormControl(
                'Data urodzenia',
                'birthDate',
                '',
                Validators.required
            ),
            registrationQuestion: new CustomFormControl(
                'Pytanie weryfikacyjne',
                'question',
                '',
                Validators.required
            ),
            registrationQuestionAnswer: new CustomFormControl(
                'Odpowiedź',
                'answer',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(3),
                    Validators.maxLength(30),
                    Validators.pattern('^[A-Za-z ]+$')
                ])
            )
        });
    }

    getValidationMessages(name: string): string[] {
        return (this.controls[name] as CustomFormControl).getValidationMessages();
    }
}

export class LoginFormGroup extends FormGroup {
    constructor() {
        super({
            email: new CustomFormControl(
                'Email',
                'email',
                '',
                Validators.compose([Validators.required, Validators.email])
            ),
            password: new CustomFormControl(
                'Hasło',
                'password',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            )
        });
    }

    getValidationMessages(name: string): string[] {
        return (this.controls[name] as CustomFormControl).getValidationMessages();
    }
}

export class ChangePasswordGroup extends FormGroup {
    constructor() {
        super({
            oldPassword: new CustomFormControl(
                'Aktualne hasło',
                'oldPassword',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            ),
            newPassword: new CustomFormControl(
                'Nowe hasło',
                'newPassword',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            ),
            newPasswordConfirmation: new CustomFormControl(
                'Potwierdź nowe hasło',
                'confimNewPassword',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            )
        });
    }

    getValidationMessages(name: string): string[] {
        return (this.controls[name] as CustomFormControl).getValidationMessages();
    }
}

export class ChangeQuestionGroup extends FormGroup {
    constructor() {
        super({
            password: new CustomFormControl(
                'Hasło',
                'password',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(8),
                    Validators.maxLength(20),
                    Validators.pattern('^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$')
                ])
            ),
            question: new CustomFormControl('Pytanie', 'question', '', Validators.required),
            answer: new CustomFormControl(
                'Odpowiedź',
                'answer',
                '',
                Validators.compose([
                    Validators.required,
                    Validators.minLength(3),
                    Validators.maxLength(30),
                    Validators.pattern('^[A-Za-z ]+$')
                ])
            )
        });
    }
}
