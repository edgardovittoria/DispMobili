import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Refresher} from 'ionic-angular';
import { PAGES } from '../pages';

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {


  constructor(public navCtrl: NavController) {

  }

  openDetails() {
    this.navCtrl.push(PAGES.WHISTLE_DETAILS);
  }

  openComments() {
    this.navCtrl.push(PAGES.COMMENTS);
  }

  createWhistle() {
    this.navCtrl.push(PAGES.WHISTLE);
  }

  openNots() {
    this.navCtrl.push(PAGES.CHAT_LIST);
  }

  search() {

  }

  openProfile() {
    this.navCtrl.push(PAGES.USER);
  }
}
