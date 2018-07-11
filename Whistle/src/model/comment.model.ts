import { User } from "./user.model";

export class Comment {
    id: number;
    author: User;
    date: Date;
    body: string;
}