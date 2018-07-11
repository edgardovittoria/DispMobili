import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Chat } from '../model/chat.model';

@Injectable()
export class ChatListService {

    constructor(private http: HttpClient) {
    }

    /*list(): Observable<Array<Chat>> {
        return this.http.get<Array<Chat>>(URL.CHATLIST);
    }*/

    list(user: number): Observable<Array<Chat>> {
        let apiURL = `${URL.CHATLIST}/${user}`;
        return this.http.get<Array<Chat>>(apiURL);
    }
}