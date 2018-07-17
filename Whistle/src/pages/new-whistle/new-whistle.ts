import { Component } from '@angular/core';
import { IonicPage, AlertController, NavController } from 'ionic-angular';
import { WhistleService } from '../../services/whistle.service';
import { Whistle } from '../../model/whistle.model';
import { User } from '../../model/user.model';
import { Call } from '../../model/call.model';
import { UserService } from '../../services/user.service';
import { dateValueRange } from '../../../node_modules/ionic-angular/umd/util/datetime-util';

@IonicPage()
@Component({
  selector: 'page-new-whistle',
  templateUrl: 'new-whistle.html'
})

export class WhistlePage {
  postType: string = 'Fun';
  user: User;
  whistle: Whistle = new Whistle();
  call: Call = new Call();


  alert = this.alertCtrl.create({
    title: 'Type selection',
    subTitle: 'Please, select at least one type!',
    buttons: ['OK']
  });

  constructor(private navCtrl: NavController, 
              private alertCtrl: AlertController, 
              private whistleService: WhistleService,
              private userService: UserService) { 

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad WhistlePage');
    this.call.callsType = 'none';
    navigator.geolocation.getCurrentPosition((position) => {
    this.userService.getUser().subscribe((user: User) => {
      this.whistle.author = user;
      this.whistle.latitude = position.coords.latitude;
      this.whistle.longitude = position.coords.longitude;
      this.call.author = user;
      this.call.latitude = position.coords.latitude;
      this.call.longitude = position.coords.longitude;
      });
    });
  }

  getLocation() {
    return "pippo";
  }

  submit() {
      if(this.postType === 'Fun') {
        this.whistle.date = new Date();
        this.whistleService.newWhistle(this.whistle).subscribe(() => {
          this.navCtrl.pop();
        });          
      }else{
        if(this.call.callsType != 'none') {
          this.call.date = new Date();
          this.whistleService.newWhistle(this.call).subscribe(() => {
            this.navCtrl.pop();
          }); 
        }else{
          this.alert.present();
        }
      }

    }
    
  

 
}
