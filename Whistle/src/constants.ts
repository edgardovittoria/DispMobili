export const USE_PROXY = true;

export const URL_BASE = USE_PROXY ? 'api' : 'localhost:8080/whistle/api';

export const STORE_PATH = URL_BASE + '/store';
export const UPDATE_PATH = URL_BASE + '/update';
export const DELETE_PATH = URL_BASE + '/delete';

export const URL = {
    WHISTLES: URL_BASE + "/whistle",
    USERS: URL_BASE + "/user",
    SIGNIN: URL_BASE + "/signin",
    LOGIN: URL_BASE + "/login",
    LOGOUT: URL_BASE + "/logout",
    CHATLIST: URL_BASE + "/chatlist",
    CHAT: URL_BASE + "/chat",
    COMMENTS: URL_BASE + "/comments",
    REACTIONS: URL_BASE + "/reactions",
    STORE: {
        WHISTLE: STORE_PATH + '/whistle',
        MESSAGE: STORE_PATH + '/message',
        CHAT: STORE_PATH + '/chat',
        REACTION: STORE_PATH + '/reaction',
        COMMENT: STORE_PATH + '/comment',
        POSITION: STORE_PATH + '/position'
    },
    UPDATE: {
        USER: UPDATE_PATH + "/utente",
        COMMENT: UPDATE_PATH + '/comment'
    },
    DELETE:{
        COMMENT: DELETE_PATH + '/comment',
        WHISTLE: DELETE_PATH + '/whistle',
        REACTION: DELETE_PATH + '/reaction'
    },
    UPLOAD: URL_BASE + '/upload'
}

export const X_AUTH = "X-Auth";

export const AUTH_TOKEN = "auth-token";

export const UTENTE_STORAGE = "utente";

export const LANGUAGE = 'lingua';