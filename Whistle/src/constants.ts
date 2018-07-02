export const USE_PROXY = true;

export const URL_BASE = USE_PROXY ? 'api' : 'http://localhost:8080/Whistle/api';

export const URL = {
    LOGIN: URL_BASE + "/login",
    LOGOUT: URL_BASE + "/logout",
    UPDATE_PROFILO: URL_BASE + "/utente/updateprofilo"
}

export const X_AUTH = "X-Auth";

export const AUTH_TOKEN = "auth-token";

export const UTENTE_STORAGE = "utente";

export const LINGUA = 'lingua';