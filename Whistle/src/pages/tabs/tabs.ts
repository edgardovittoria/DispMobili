import { Component } from '@angular/core';
import { IonicPage } from 'ionic-angular';
import { PAGES } from '../pages';


@IonicPage()
@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html'
})
export class TabsPage {

    home: string = PAGES.HOME;
    notifications: string = PAGES.CHAT_LIST;
    search: any;
    profile: string = PAGES.USER;
}