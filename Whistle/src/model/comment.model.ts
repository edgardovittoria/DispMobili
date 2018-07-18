import { User } from "./user.model";
import { Whistle } from "./whistle.model";

export class Comment {
    id: number;
    author: User;
    date: Date;
    body: string;
    whistle: Whistle;
}