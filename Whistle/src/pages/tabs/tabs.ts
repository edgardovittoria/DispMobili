import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { PAGES } from '../pages';


@IonicPage()
@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html'
})
export class TabsPage {

    home: string = PAGES.HOME;
    notifications: string = PAGES.CHAT_LIST;
    profile: string = PAGES.USER;

    constructor(public navCtrl: NavController) {

    }

    
}