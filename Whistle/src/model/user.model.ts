import { Chat } from "./chat.model";

export class User {
    name: string;
    mail: string;
    password: string;
    photo: string; //?????
    description: string;
    solved_calls: number;
    chats: Array<Chat>;
}