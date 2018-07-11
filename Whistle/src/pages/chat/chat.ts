import { Component } from '@angular/core';
import { IonicPage, NavParams } from '../../../node_modules/ionic-angular/umd';
import { User } from '../../model/user.model';
import { UserService } from '../../services/user.service';


@IonicPage()
@Component({ //qui vanno i decorators del componente
    selector: 'page-chat',  //definisce il tag html (??) da richiamare per fare i nested ???
    templateUrl: 'chat.html' //quale html è associato al componente
})

export class ChatPage {
    //qui va tutta la logica della pagina
    user: User;

    constructor(public userService: UserService, public navParams: NavParams) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad ChatPage');
        this.userService.findById(this.navParams.data.userId).subscribe((data: User) => {
            this.user = data;
          });
    }
} 