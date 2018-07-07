import { IonicPage, NavController } from "ionic-angular";
import { Component } from "@angular/core";
import { PAGES } from "../pages";


@IonicPage()
@Component({
    templateUrl: 'whistle-details.html'
})
export class WhistleDetailsPage {

    constructor(public navCtrl: NavController) {

    }

    newChat() {
        this.navCtrl.push(PAGES.CHAT);
    }
}