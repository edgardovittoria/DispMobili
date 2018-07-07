import { Component } from '@angular/core';
import { IonicPage } from '../../../node_modules/ionic-angular/umd';


@IonicPage()
@Component({ //qui vanno i decorators del componente
    selector: 'page-chat',  //definisce il tag html (??) da richiamare per fare i nested ???
    templateUrl: 'chat.html' //quale html è associato al componente
})

export class ChatPage {
    //qui va tutta la logica della pagina
} 