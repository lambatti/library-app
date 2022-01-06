export class UserRegister {
    constructor(
        public firstName?: string,
        public lastName?: string,
        public email?: string,
        public password?: string,
        public gender?: string,
        public dateOfBirth?: string,
        public registractionQuestion?: string,
        public registractionQuestionAnswer?: string
    ) {}
}

export class UserLogin {
    constructor(public email?: string, public password?: string) {}
}

export class User {
    constructor(
        public firstName?: string,
        public lastName?: string,
        public gender?: string,
        public birthDate?: string,
        public accountCreationDate?: string,
        public email?: string
    ) {}
}

export class ChangePassword {
    constructor(
        public oldPassword?: string,
        public newPassword?: string,
        public confimNewPassword?: string
    ) {}
}

export class ChangeQuestion {
    constructor(public password?: string, public question?: string, public answer?: string) {}
}

export class Question {
    constructor(public key?: string, public value?: string) {}
}
