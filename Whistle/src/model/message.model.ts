import { User } from "./user.model";

export class Message {
    user: User;
    text: string;
    date: Date;
}