import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Refresher} from 'ionic-angular';
import { PAGES } from '../pages';
import { Whistle } from '../../model/whistle.model';
import { WhistleService } from '../../services/whistle.service';

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  whistles: Array<Whistle>;

  constructor(public navCtrl: NavController, public whistleService: WhistleService) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HomePage');
    this.whistleService.list().subscribe((data: Array<Whistle>) => {
      this.whistles = data;
    });
  }

  openDetails(w: Whistle) {
    this.navCtrl.push(PAGES.WHISTLE_DETAILS, {whistleId: w.id});
  }

  openComments(w: Whistle) {
    this.navCtrl.push(PAGES.COMMENTS, {whistleId: w.id});
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
