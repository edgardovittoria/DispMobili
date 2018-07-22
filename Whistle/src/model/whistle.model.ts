
import { User } from './user.model';

export class Whistle {
    id: number;
    author: User;
    body: string;
    type: string;
    date: Date;
    latitude: number;
    longitude: number;
    reactions: number;
    comments: number;
    id_reaction: number;

    //comments: Array<Comment>;
}