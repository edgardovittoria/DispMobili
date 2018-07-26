import { Component } from '@angular/core';
import { IonicPage, NavParams, InfiniteScroll, LoadingController } from 'ionic-angular';
import { User } from '../../model/user.model';
import { ChatService } from '../../services/chat.service';
import { Message } from '../../model/message.model';
import { UserService } from '../../services/user.service';
import { Chat } from '../../model/chat.model';


@IonicPage()
@Component({ 
    selector: 'page-chat',
    templateUrl: 'chat.html' 
})

export class ChatPage {

    page: number = 0;
    myMessage: Message = new Message();
    chat: Chat;
    messages: Array<Message>;
    partecipant: User;

    constructor(private navParams: NavParams,
                private userService: UserService,           
                private chatService: ChatService,
                private loadingCtrl: LoadingController) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad ChatPage');
        console.log(this.navParams.data.chat);
        this.partecipant = this.navParams.data.chat.partecipant;
        this.userService.getUser().subscribe((user: User) => {
            this.chat = this.navParams.data.chat;
            this.chat.opener = user;
            this.myMessage.author = user;
            this.myMessage.relativoa = this.navParams.data.chat;
            this.chatService.getMessages(this.chat.opener.id, this.chat.partecipant.id, this.page).subscribe((data: Array<Message>) => {                
                this.messages = this.mapMessages(data);
            });
            window.scroll(0,100000);
        });
    }

    mapMessages(messages: Array<Message>) {
        messages.map((message) => {
            let date = new Date(message.date);
            message.hour = date.getHours() + ":" + date.getMinutes();
            if (message.author.id === this.chat.opener.id) {
                message.mine = true;
            } else {
                message.mine = false;
            }
        });
        return messages;
    }

    submit() {
        let date = new Date();
        this.myMessage.date = date.getTime();
        let newMessage = new Message();
        newMessage.hour = date.getHours() + ":" + date.getMinutes();
        newMessage.body = this.myMessage.body;
        newMessage.mine = true;

        
            this.chatService.sendMessage(this.myMessage).subscribe(() => {
                this.messages = this.messages.concat(newMessage);
                this.myMessage.body = '';
            });
        
    }

    loadMoreMessages(infiniteScroll: InfiniteScroll) {
        console.log("load more");
        console.log(this.page);
        this.page++;
        this.chatService.getMessages(this.chat.opener.id, this.chat.partecipant.id, this.page).subscribe((data: Array<Message>) => {
            this.messages = this.messages.concat(this.mapMessages(data));
            this.messages.reverse();
            if (data.length == 0) {
                this.page--;
            }
            infiniteScroll.complete();
        });
    }



    doRefresh() {        
        let loading = this.loadingCtrl.create({
            
          });
        loading.present();  
        this.page = 0;
        this.chatService.getMessages(this.chat.opener.id, this.chat.partecipant.id, this.page).subscribe((data: Array<Message>) => {
            this.messages = this.mapMessages(data);
            loading.dismiss();
        });
    }

} 