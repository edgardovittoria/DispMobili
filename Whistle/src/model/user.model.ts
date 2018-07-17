import { Chat } from "./chat.model";

export class User {
    id: number;
    nome: string;
    cognome: string;
    username: string;
    email: string;
    password: string;
    photo: string; //?????
    description: string;
    solved_calls: number;
    chats: Array<Chat>;

}