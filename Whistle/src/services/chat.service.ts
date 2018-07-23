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

    createChat(c: Chat): Observable<Chat> {
        return this.http.post<Chat>(URL.STORE.CHAT, c);
    }

    sendMessage(m: Message) {
        return this.http.post(URL.STORE.MESSAGE, m);
    }


    getChatList(userId: number): Observable<Array<Chat>> {
        let apiURL = `${URL.CHATLIST}/${userId}`;
        return this.http.get<Array<Chat>>(apiURL);
    }

    getMessages(opId: number, partId: number): Observable<Array<Message>> {
        let apiURL = `${URL.CHAT}/${opId}/${partId}`;
        return this.http.get<Array<Message>>(apiURL);
    }
}