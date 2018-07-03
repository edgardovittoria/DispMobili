import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Refresher } from 'ionic-angular';
import { PAGES } from '../pages';

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {


  constructor(public navCtrl: NavController) {

  }

  createWhistle() {
    this.navCtrl.push(PAGES.WHISTLE);
  }

  openNots() {
        
  }

  search() {

  }

  openProfile() {
    this.navCtrl.push(PAGES.USER);
  }
}
