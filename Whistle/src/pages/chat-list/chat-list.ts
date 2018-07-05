import { IonicPage, NavController, NavParams } from "ionic-angular";
import { Component } from "@angular/core";
import { Chat } from "../../model/chat.model";
import { PAGES } from "../pages";
import { ChatListService } from "../../services/chat-list.service";

@IonicPage()
@Component({
    selector: 'page-chat-list',
    templateUrl: 'chat-list.html'
})
export class ChatListPage {
    chats: Array<Chat>;

    constructor(public navCtrl: NavController, public navParams: NavParams /*, public chatListService: ChatListService*/) {

    }

    /*loadData() {
        //console.log('ionViewDidLoad NotiziePage');
        this.chatListService.list().subscribe((data: Array<Chat>) => {
          this.chats = data;
        });
      }*/

    openChat(selectedChat: Chat) {
        this.navCtrl.push(PAGES.CHAT, selectedChat);
    }
}