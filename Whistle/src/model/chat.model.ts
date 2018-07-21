
import { User } from "./user.model";

export class Chat {
    id: string;
    opener: User;
    partecipant: User;
}