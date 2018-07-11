import {Comment} from './comment.model';
import { User } from './user.model';

export class Whistle {
    id: number;
    author: User;
    body: string;
    date: Date;
    location: string;
    reactions: Array<User>;
    comments: Array<Comment>;
}