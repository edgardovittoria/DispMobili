import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Whistle } from '../model/whistle.model';
import { Comment } from '../model/comment.model';

@Injectable()
export class WhistleService {

    constructor(private http: HttpClient) {
    }

    list(position): Observable<Array<Whistle>> {
        //qui ci vuole il controllo della posizione
        
            let apiURL = `${URL.WHISTLES}/${position.coords.latitude}/${position.coords.longitude}`;
            return this.http.get<Array<Whistle>>(apiURL);

        
        //return this.http.get<Array<Whistle>>(apiURL);
    }

    newWhistle(whistle: Whistle) {
        return this.http.post<Whistle>(URL.STORE.WHISTLE, whistle);
    }

    findById(whistleId: number): Observable<Whistle> {
        let apiURL = `${URL.WHISTLES}/${whistleId}`;
        return this.http.get<Whistle>(apiURL);
    }

    getComments(whistleId: number): Observable<Array<Comment>> {
        let apiURL = `${URL.COMMENTS}/${whistleId}`;
        return this.http.get<Array<Comment>>(apiURL);
    }
}