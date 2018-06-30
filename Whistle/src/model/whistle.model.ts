import {Comment} from './comment.model';
import { User } from './user.model';

export class Whistle {
    body: string;
    date: Date;
    location: Geolocation;
    reactions: Array<User>;
    comments: Array<Comment>;
}