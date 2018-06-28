
'model' contiene la struttura della logica applicativa,quindi la traduzione dell'UML (entity).

'services' contiene delle funzionalità (e quindi credo anche i metodi delle classi visto che 
non sono in entity) legate all'applicazione.

'assets/i18n' contiene le lingue supportate dall'applicazione (penso sfrutti la nomenclatura 
assegnata dentro i json per switchare facilmente dall'una all'altra). (vanno espansi)

'pages' contiene cartelle per ogni schermata accessibile dell'applicazione (rifarsi al low-fi 
wireframe a tal proposito). Ognuna di queste cartelle contiene un .html, .module.ts, .scss e 
.ts . Bisogna anche creare la pagina tramite il comando 'ionic generate page (nome-pagina).

Angular JS  built in service  $http  is used to make http server requests.  More often than 
not you would find yourself in a situation where you would want to run hooks for the http 
calls, i.e execute some logic before or after the http call. For example appending the auth 
token  to every api request or generic http response error handling. For this $http 
interceptors become quite handy.[...]There are four types of interceptors Request, Response, 
Request error and Response Error. Every interceptor factory should have one out of these 
four methods defined rest are optional. (preso da internet)

