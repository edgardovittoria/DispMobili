
import { User } from "./user.model";

export class Chat {
    id: number;
    opener: User;
    partecipant: User;
}