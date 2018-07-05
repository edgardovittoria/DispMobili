import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Chat } from '../model/chat.model';

@Injectable()
export class ChatListService {

    constructor(private http: HttpClient) {
    }

    list(): Observable<Array<Chat>> {
        return this.http.get<Array<Chat>>(URL.CHATLIST);
    }

    findById(notiziaId: number): Observable<Chat> {
        let apiURL = `${URL.CHATLIST}/${notiziaId}`;
        return this.http.get<Chat>(apiURL);
    }
}