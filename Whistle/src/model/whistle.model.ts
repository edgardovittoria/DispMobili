import {Comment} from './comment.model';
import { User } from './user.model';

export class Whistle {
    author: User;
    body: string;
    date: Date;
    location: Geolocation;
    reactions: Array<User>;
    comments: Array<Comment>;
}