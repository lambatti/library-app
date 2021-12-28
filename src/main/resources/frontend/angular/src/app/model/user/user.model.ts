export class UserRegister {
    constructor(
        public firstName?: string,
        public lastName?: string,
        public email?: string,
        public password?: string,
        public gender?: string,
        public birthDate?: string,
        public registractionQuestion?: string,
        public registractionQuestionAnswer?: string
    ) {}
}
