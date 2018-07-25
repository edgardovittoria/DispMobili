import { Component } from '@angular/core';
import { IonicPage, AlertController, NavController } from 'ionic-angular';
import { WhistleService } from '../../services/whistle.service';
import { Whistle } from '../../model/whistle.model';
import { User } from '../../model/user.model';
import { Call } from '../../model/call.model';
import { UserService } from '../../services/user.service';
import { PAGES } from '../pages';
import { TranslateService } from '../../../node_modules/@ngx-translate/core';

@IonicPage()
@Component({
  selector: 'page-new-whistle',
  templateUrl: 'new-whistle.html'
})

export class WhistlePage {
  newCallTitle: string;
  newCallSubTitle: string;
  postType: string = 'Fun';
  user: User;
  whistle: Whistle = new Whistle();
  call: Call = new Call();


 

  constructor(private navCtrl: NavController, 
              private alertCtrl: AlertController, 
              private whistleService: WhistleService,
              private userService: UserService,
              private translateService: TranslateService) { 

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad WhistlePage');
    this.translateService.get('NEWCALL_ERROR_SUB_TITLE').subscribe((data) => {
      this.newCallSubTitle = data;
    });
    this.translateService.get('NEWCALL_ERROR_TITLE').subscribe((data) => {
      this.newCallTitle = data;
    });
    this.call.callsType = 'none';
    this.userService.getUser().subscribe((user: User) => {
      this.user = user;
      this.whistle.author = this.user;
      this.call.author = this.user;
    });
    navigator.geolocation.getCurrentPosition((position) => {
      
      this.whistle.latitude = position.coords.latitude;
      this.whistle.longitude = position.coords.longitude;
      this.whistle.type = "Fun";
      
      this.call.latitude = position.coords.latitude;
      this.call.longitude = position.coords.longitude;
      this.call.type = "Call";
      
    });
  }

  submit() {
    let date = new Date();
      if(this.postType === 'Fun') {
        this.whistle.date = date.getTime();
        this.whistleService.newWhistle(this.whistle).subscribe(() => {
          this.navCtrl.push(PAGES.HOME);
        });          
      }else{
        if(this.call.callsType != 'none') {
          this.call.date = date.getTime();
          this.whistleService.newWhistle(this.call).subscribe(() => {
            this.navCtrl.push(PAGES.HOME);
          }); 
        }else{
          let alert = this.alertCtrl.create({
            title: this.newCallTitle,
            subTitle: this.newCallSubTitle,
            buttons: ['OK']
          });
          alert.present();
        }
      }

    }
    
  

 
}
