import { IonicPage, NavController, Nav } from "ionic-angular";
import { Component } from "@angular/core";
import { Chat } from "../../model/chat.model";
import { PAGES } from "../pages";
import { ChatService } from "../../services/chat.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";

@IonicPage()
@Component({
    selector: 'page-chat-list',
    templateUrl: 'chat-list.html'
})
export class ChatListPage {
    chats: Array<Chat>;

    constructor(private navCtrl: NavController,
                private nav: Nav,
                private chatService: ChatService,
                private userService: UserService) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad ChatListPage');
        this.userService.getUser().subscribe((user: User) => {
            this.chatService.getChatList(user.id).subscribe((data: Array<Chat>) => {
                this.chats = data;
                console.log(data);
              });
        })
        
      }

    openChat(selectedChat: Chat) {
        this.nav.push(PAGES.CHAT, {chat: selectedChat}); 
        //this.navCtrl.push(PAGES.CHAT, {chat: selectedChat});          
    }

}