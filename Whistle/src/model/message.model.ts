import { User } from "./user.model";
import { Chat } from "./chat.model";

export class Message {
    id: number;
    relativoa: Chat;
    author: User;
    body: string;
    date: number;
    hour: string;
    mine: boolean;
}