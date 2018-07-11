import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { URL } from '../constants';
import { Whistle } from '../model/whistle.model';

@Injectable()
export class WhistleService {

    constructor(private http: HttpClient) {
    }

    list(): Observable<Array<Whistle>> {
        return this.http.get<Array<Whistle>>(URL.WHISTLES);
    }

    newWhistle(whistle: Whistle) {
        return this.http.post<Whistle>(URL.STORE_WHISTLE, whistle);
    }

    findById(whistleId: number): Observable<Whistle> {
        let apiURL = `${URL.WHISTLES}/${whistleId}`;
        return this.http.get<Whistle>(apiURL);
    }
}