import { User } from "./user.model";
import { Whistle } from "./whistle.model";

export class Comment {
    id_whistle: number;
    author: User;
    date: Date;
    body: string;
    whistle: Whistle;
}