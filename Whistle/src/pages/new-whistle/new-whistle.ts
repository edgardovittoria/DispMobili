import { Component } from '@angular/core';
import { IonicPage, AlertController } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-new-whistle',
  templateUrl: 'new-whistle.html'
})

export class WhistlePage {
  type: string = 'Fun';
  callTypes: string = 'None';

  alert = this.alertCtrl.create({
    title: 'Type selection',
    subTitle: 'Please, select at least one type!',
    buttons: ['OK']
  });

  constructor(public alertCtrl: AlertController) { 

  }

  submit() {
    if(this.callTypes === 'None' && this.type != 'Fun') {
      this.alert.present();
    }else{
      //server stuff
    }
  }

 
}
