import { Component } from '@angular/core';
import { IonicPage, NavParams } from 'ionic-angular';
import { User } from '../../model/user.model';
import { ChatService } from '../../services/chat.service';
import { Message } from '../../model/message.model';
import { UserService } from '../../services/user.service';


@IonicPage()
@Component({ //qui vanno i decorators del componente
    selector: 'page-chat',  
    templateUrl: 'chat.html' //quale html è associato al componente
})

export class ChatPage {
    //qui va tutta la logica della pagina
    messages: Array<Message>;
    partecipant: User;

    constructor(private navParams: NavParams,
                private userService: UserService,
                private chatService: ChatService) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad ChatPage');
        this.partecipant = this.navParams.data.chat.partecipant;
        this.chatService.getMessages(this.navParams.data.chat.id).subscribe((data: Array<Message>) => {
            this.userService.getUser().subscribe((user: User) => {
                data.map((message) => {
                    if(message.author.id === user.id) {
                        message.mine = true;
                    }else{
                        message.mine = false;
                    }
                });
                this.messages = data;
            });
            
        });
    }
} 