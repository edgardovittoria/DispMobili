import { User } from "./user.model";

export class Comment {
    author: User;
    date: Date;
    body: string;
}