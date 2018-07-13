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

    list(): Observable<Array<Whistle>> {
        //qui ci vuole il controllo della posizione
        navigator.geolocation.getCurrentPosition((position) => {
            //return this.http.get... qualcosa del genere
        });
        
        return this.http.get<Array<Whistle>>(URL.WHISTLES);
    }

    newWhistle(whistle: Whistle) {
        return this.http.post<Whistle>(URL.STORE.WHISTLE, whistle);
    }

    findById(whistleId: number): Observable<Whistle> {
        let apiURL = `${URL.WHISTLES}/${whistleId}`;
        return this.http.get<Whistle>(apiURL);
    }

    getComments() {
        return this.http.get<Array<Comment>>(URL.COMMENTS);
    }
}