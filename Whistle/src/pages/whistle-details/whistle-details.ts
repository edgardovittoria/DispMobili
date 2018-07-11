import { IonicPage, NavController, NavParams } from "ionic-angular";
import { Component } from "@angular/core";
import { PAGES } from "../pages";
import { Whistle } from "../../model/whistle.model";
import { WhistleService } from "../../services/whistle.service";


@IonicPage()
@Component({
    templateUrl: 'whistle-details.html'
})
export class WhistleDetailsPage {
    whistle: any;


    constructor(public navCtrl: NavController, public navParams: NavParams,
                public whistleService: WhistleService) {

    }

    newChat() {
        this.navCtrl.push(PAGES.CHAT);
    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad WhistleDetailsPage');
        this.whistleService.findById(this.navParams.data.id).subscribe((data: Whistle) => {
          this.whistle = data;
        });
      }
}