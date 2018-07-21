import {Comment} from './comment.model';
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
    reacted: boolean;

    //comments: Array<Comment>;
}