export const USE_PROXY = true;

export const URL_BASE = USE_PROXY ? 'api' : 'localhost:8080/whistle/api';

export const STORE_PATH = URL_BASE + '/store';
export const UPDATE_PATH = URL_BASE + '/update';

export const URL = {
    WHISTLES: URL_BASE + "/whistle",
    USERS: URL_BASE + "/user",
    LOGIN: URL_BASE + "/login",
    LOGOUT: URL_BASE + "/logout",
    CHATLIST: URL_BASE + "/chatlist",
    COMMENTS: URL_BASE + "/comments",
    REACTIONS: URL_BASE + "/reactions",
    STORE: {
        WHISTLE: STORE_PATH + '/whistle',
        MESSAGE: STORE_PATH + '/message',
        REACTION: STORE_PATH + '/reaction',
        POSITION: STORE_PATH + '/position'
    },
    UPDATE: {
        USER: UPDATE_PATH + "/utente"
    }
}

export const X_AUTH = "X-Auth";

export const AUTH_TOKEN = "auth-token";

export const UTENTE_STORAGE = "utente";

export const LANGUAGE = 'lingua';