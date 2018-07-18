import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Whistle } from '../model/whistle.model';
import { Comment } from '../model/comment.model';
import { Reaction } from '../model/reaction.model';
import { UserService } from './user.service';

@Injectable()
export class WhistleService {

    constructor(private http: HttpClient, private userService: UserService) {
    }

    list(position): Observable<Array<Whistle>> {
        let apiURL = `${URL.WHISTLES}/${position.coords.latitude}/${position.coords.longitude}`;
        return this.http.get<Array<Whistle>>(apiURL);
    }

    newWhistle(whistle: Whistle) {
        return this.http.post<Whistle>(URL.STORE.WHISTLE, whistle);
    }

    findById(whistleId: number): Observable<Whistle> {
        let apiURL = `${URL.WHISTLES}/${whistleId}`;
        return this.http.get<Whistle>(apiURL);
    }

    setReaction(r: Reaction) {
        return this.http.post(URL.STORE.REACTION, r);
    }

    countReactions(whistleId: number): Observable<Array<Reaction>> {
        let apiURL = `${URL.REACTIONS}/${whistleId}`;
        return this.http.get<Array<Reaction>>(apiURL);
    }

    countComments() {

    }

    getComments(whistleId: number, page: number): Observable<Array<Comment>> {
        let apiURL = `${URL.COMMENTS}/${whistleId}/${page}`;
        return this.http.get<Array<Comment>>(apiURL);
    }

    newComment(comment: Comment) {    
        return this.http.post(URL.STORE.COMMENT, comment);
    }
}