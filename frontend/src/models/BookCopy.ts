import { Status } from "../constants/enums"

export interface BookCopy {
    id: number,
    createdAt: Date,
    status: Status,
    title: string,
    author: AuthorShort

}

export interface AuthorShort {
    id: number,
    firstName: string,
    lastName: string
}