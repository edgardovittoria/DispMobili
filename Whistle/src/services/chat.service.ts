import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Chat } from '../model/chat.model';
import { Message } from '../model/message.model';

@Injectable()
export class ChatService {

    constructor(private http: HttpClient) {
    }

    /*list(): Observable<Array<Chat>> {
        return this.http.get<Array<Chat>>(URL.CHATLIST);
    }*/

    getChatList(userId: number): Observable<Array<Chat>> {
        let apiURL = `${URL.CHATLIST}/${userId}`;
        return this.http.get<Array<Chat>>(apiURL);
    }

    getMessages(chatId: number): Observable<Array<Message>> {
        let apiURL = `${URL.CHAT}/${chatId}`;
        return this.http.get<Array<Message>>(apiURL);
    }
}