import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Whistle } from '../model/whistle.model';
import { Comment } from '../model/comment.model';
import { Reaction } from '../model/reaction.model';

@Injectable()
export class WhistleService {

    constructor(private http: HttpClient) {
    }

    list(position, page: number): Observable<Array<Whistle>> {
        let apiURL = `${URL.WHISTLES}/${position.coords.latitude}/${position.coords.longitude}/${page}`;
        return this.http.get<Array<Whistle>>(apiURL);
    }

    newWhistle(whistle: Whistle) {
        return this.http.post<Whistle>(URL.STORE.WHISTLE, whistle);
    }

    findById(whistleId: number): Observable<Whistle> {
        let apiURL = `${URL.WHISTLES}/${whistleId}`;
        return this.http.get<Whistle>(apiURL);
    }

    setReaction(r: Reaction): Observable<number> {
        return this.http.post<number>(URL.STORE.REACTION, r);
    }

    deleteReaction(idReact: number) {
        let deletUrl = `${URL.DELETE.REACTION}/${idReact}`;
        return this.http.delete(deletUrl);
    }

    countReactions(whistleId: number): Observable<Array<Reaction>> {
        let apiURL = `${URL.REACTIONS}/${whistleId}`;
        return this.http.get<Array<Reaction>>(apiURL);
    }

    getComments(whistleId: number, page: number): Observable<Array<Comment>> {
        let apiURL = `${URL.COMMENTS}/${whistleId}/${page}`;
        return this.http.get<Array<Comment>>(apiURL);
    }

    newComment(comment: Comment) {    
        return this.http.post(URL.STORE.COMMENT, comment);
    }

    deleteComment(comment: Comment){
        let deletUrl = `${URL.DELETE.COMMENT}/${comment.id}`;
        return this.http.delete(deletUrl);
    }

    updateComment(comment: Comment){
        return this.http.put(URL.UPDATE.COMMENT, comment);
    }

    deleteWhistle(whistle: Whistle){
        let deletUrl = `${URL.DELETE.WHISTLE}/${whistle.id}`;
        return this.http.delete(deletUrl);
    }
}