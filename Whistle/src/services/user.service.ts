import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { Observable } from 'rxjs/Observable';
import { fromPromise } from 'rxjs/observable/fromPromise';

import { AUTH_TOKEN, URL, UTENTE_STORAGE, X_AUTH } from '../constants';
import { User } from '../model/user.model';


export interface Account {
    username: string;
    password: string;

}

@Injectable()
export class UserService {
    private userToken: string;

    constructor(private http: HttpClient, private storage: Storage) {
        this.storage.get(AUTH_TOKEN).then((token) => {
            this.userToken = token;
        });
    }

    login(account: Account): Observable<User> {
        return this.http.post<User>(URL.LOGIN, account, { observe: 'response' })
            .map((resp: HttpResponse<User>) => {
                const token = resp.headers.get(X_AUTH);
                this.storage.set(AUTH_TOKEN, token);
                this.userToken = token;
                //User memorizzato nello storage in modo tale che se si vuole cambiare il
                //profilo dell'utente stesso non si fa una chiamata REST. 
                this.storage.set(UTENTE_STORAGE, resp.body);
                return resp.body;
            });       
    }

    logout() {
        this.userToken = "";
        this.storage.remove(AUTH_TOKEN);
        this.storage.remove(UTENTE_STORAGE);
        //Nessuna chiamata al server perche' JWT e' stateless quindi non prevede alcun logout.
        //Per gestirlo si dovrebbe fare lato server una blacklist.
    }

    getUser(): Observable<User> {
        return fromPromise(this.storage.get(UTENTE_STORAGE));
    }

    findById(userId: number): Observable<User> {
        let apiURL = `${URL.USERS}/${userId}`;
        return this.http.get<User>(apiURL);
    }

    getUserToken(): string {
        return this.userToken;
    }

    updateUser(newUser: User): Observable<User> {
        return this.http.post<User>(URL.UPDATE.USER, newUser, { observe: 'response' })
            .map((resp: HttpResponse<User>) => {
                //Aggiornamento dell'utente nello storage.
                //User memorizzato nello storage per evitare chiamata REST quando si vuole modificare il profilo
                //e se l'utente chiude la app e la riapre i dati sono gia' presenti
                this.storage.set(UTENTE_STORAGE, resp.body);
                return resp.body;
            });
    }

    uploadProfileImg(img: File) {
        return this.http.post(URL.UPLOAD, img);
    }


}