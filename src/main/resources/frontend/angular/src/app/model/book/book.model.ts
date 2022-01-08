export class Book {
    constructor(
        public id?: number,
        public coverUrl?: string,
        public title?: string,
        public author?: string,
        public publicationDate?: string,
        public genre?: string,
        public isHard?: boolean,
        public count?: number,
        public available?: boolean,
        public description?: string
    ) {}
}

export class BorrowedBook {
    constructor(
        public id?: number,
        public coverUrl?: string,
        public title?: string,
        public author?: string,
        public publicationDate?: string,
        public genre?: string,
        public isHard?: boolean,
        public available?: boolean,
        public borrowDate?: string,
        public returnData?: string
    ) {}
}
