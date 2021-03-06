import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { Observable } from 'rxjs/Observable';
import { fromPromise } from 'rxjs/observable/fromPromise';

import { LANGUAGE } from '../constants';

export interface Language {
    name: string;
    code: string;
}

@Injectable()
export class LanguageService {

    english: Language = { name: "English", code: "en" };
    languages: Array<Language> = [this.english, { name: "Italiano", code: "it" }];

    constructor(private storage: Storage) {

    }

    getCurrLang(): Observable<string> {
        return fromPromise(this.storage.get(LANGUAGE));
    }

    getBestLang(): string {
        return this.english.code;
    }

    getLangs(): Array<Language> {
        return this.languages;
    }

    updateLang(newLang: string) {
        this.storage.set(LANGUAGE, newLang);
    }

}