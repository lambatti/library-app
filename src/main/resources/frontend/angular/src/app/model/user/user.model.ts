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
        public dateOfBirth?: string,
        public creationDate?: string,
        public email?: string
    ) {}
}
