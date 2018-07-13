import { Component } from '@angular/core';
import { IonicPage, AlertController, NavController } from 'ionic-angular';
import { WhistleService } from '../../services/whistle.service';
import { Whistle } from '../../model/whistle.model';
import { User } from '../../model/user.model';
import { Call } from '../../model/call.model';
import { UserService } from '../../services/user.service';

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
    this.userService.getUser().subscribe((user: User) => {
      this.whistle.author = user;
      this.call.author = user;
  });
  }

  getLocation() {
    return "pippo";
  }

  submit() {
      if(this.postType === 'Fun') {
        this.whistleService.newWhistle(this.whistle).subscribe(() => {
          this.navCtrl.pop();
        });          
      }else{
        if(this.call.callsType != 'none') {
          this.whistleService.newWhistle(this.call).subscribe(() => {
            this.navCtrl.pop();
          }); 
        }else{
          this.alert.present();
        }
      }

    }
    
  

 
}
