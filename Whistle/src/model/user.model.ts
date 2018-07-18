import { Chat } from "./chat.model";

export class User {
    id: number;
    name: string;
    surname: string;
    username: string;
    email: string;
    password: string;
    photo: string; //?????
    description: string;
    solved_calls: number;
    chats: Array<Chat>;

}