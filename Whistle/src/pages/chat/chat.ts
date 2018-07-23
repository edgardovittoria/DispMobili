import { Component } from '@angular/core';
import { IonicPage, NavParams, Refresher, InfiniteScroll } from 'ionic-angular';
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
        private chatService: ChatService) {

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
            this.chatService.getMessages(this.chat.opener.id, this.chat.partecipant.id).subscribe((data: Array<Message>) => {                
                this.messages = this.setAuthor(data);
            });
            window.scrollTo(0,document.body.scrollHeight);
        });
    }

    setAuthor(messages: Array<Message>) {
        messages.map((message) => {
            if (message.author.id === this.chat.opener.id) {
                message.mine = true;
            } else {
                message.mine = false;
            }
        });
        return messages;
    }

    submit() {
        this.myMessage.date = new Date();
        if (this.messages.length > 0) {
            this.chatService.sendMessage(this.myMessage).subscribe(() => {
                this.messages = this.messages.concat(this.myMessage);
            });
        } else {
            this.chatService.createChat(this.chat).subscribe((c: Chat) => {
                this.myMessage.relativoa = c;
                this.chatService.sendMessage(this.myMessage).subscribe(() => {
                    this.messages = this.messages.concat(this.myMessage);
                });
            });
        }
    }

    loadMoreMessages(infiniteScroll: InfiniteScroll) {
        console.log("load more");
        this.page++;
        this.chatService.getMessages(this.chat.opener.id, this.chat.partecipant.id).subscribe((data: Array<Message>) => {
            this.messages = this.messages.concat(this.setAuthor(data));
            this.messages.reverse();
            if (data.length == 0) {
                this.page--;
            }
            infiniteScroll.complete();
        });
    }

    doRefresh(refresher: Refresher) {
        /*
        this.page = 0;
        this.chatService.getMessages(this.chat.opener.id, this.chat.partecipant.id).subscribe((data: Array<Message>) => {
            this.messages = this.setAuthor(data);
            refresher.complete();
        });//*/
    }

} 