import { User } from "./user.model";
import { Whistle } from "./whistle.model";

export class Comment {
    id: number;
    author: User;
    date: number;
    time: string;
    body: string;
    id_whistle: Whistle;
    mine: boolean;
}