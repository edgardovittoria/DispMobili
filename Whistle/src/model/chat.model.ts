import { Message } from "./message.model";
import { User } from "./user.model";

export class Chat {
    id: string;
    opener: User;
    partecipant: User;
    messages: Array<Message>;
}