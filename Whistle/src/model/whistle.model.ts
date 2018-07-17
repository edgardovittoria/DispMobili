import {Comment} from './comment.model';
import { User } from './user.model';

export class Whistle {
    id: number;
    author: User;
    body: string;
    date: Date;
    latitude: number;
    longitude: number;
    reactions: number;
    comments: number;

    //comments: Array<Comment>;
}