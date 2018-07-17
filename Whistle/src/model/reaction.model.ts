import { User } from "./user.model";
import { Whistle } from "./whistle.model";

export class Reaction {
    id_reaction: number;
    reactionsOf: User;
    whistle: Whistle;
}