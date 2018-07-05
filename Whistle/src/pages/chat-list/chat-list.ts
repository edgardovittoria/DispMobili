import { IonicPage, NavController } from "ionic-angular/umd";
import { Component } from "@angular/core";
import { Chat } from "../../model/chat.model";
import { PAGES } from "../pages";

@IonicPage()
@Component({
    templateUrl: 'chat-list.html'
})
export class ChatListPage {

    constructor(public navCtrl: NavController) {

    }

    openChat(selectedChat: Chat) {
        this.navCtrl.push(PAGES.CHAT, selectedChat);
    }
}