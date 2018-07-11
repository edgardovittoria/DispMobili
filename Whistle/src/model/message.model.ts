import { User } from "./user.model";

export class Message {
    id: number;
    author: User;
    body: string;
    date: Date;
}