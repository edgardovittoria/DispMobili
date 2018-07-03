import { Chat } from "./chat.model";

export class User {
    name: string;
    mail: string;
    password: string;
    photo: string; //?????
    description: string;
    solved_calls: number;
    chats: Array<Chat>;

    constructor(name: string, mail: string, password: string) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}