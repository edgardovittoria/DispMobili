import { Component } from '@angular/core';
import { IonicPage, AlertController, NavParams, NavController } from 'ionic-angular';
import { WhistleService } from '../../services/whistle.service';
import { Whistle } from '../../model/whistle.model';
import { FormBuilder, FormGroup, Validators } from '../../../node_modules/@angular/forms';
import { User } from '../../model/user.model';
import { Call } from '../../model/call.model';

@IonicPage()
@Component({
  selector: 'page-new-whistle',
  templateUrl: 'new-whistle.html'
})

export class WhistlePage {
  type: string = 'Fun';
  todo : FormGroup;
  user: User;
  whistle: any;

  alert = this.alertCtrl.create({
    title: 'Type selection',
    subTitle: 'Please, select at least one type!',
    buttons: ['OK']
  });

  constructor(public navCtrl: NavController, public alertCtrl: AlertController, 
    public whistleService: WhistleService, public navParams: NavParams, private formBuilder: FormBuilder) { 
      
      this.user = new User('pippo','baudo','password');
      
      this.todo = this.formBuilder.group({
        body: ['', Validators.required],
        type: [''],
        callsType: [''], 
        author: this.user,
      });

      
  }

  logForm(){
    console.log(this.todo.value)
  }

  getLocation() {
    return "pippo";
  }

  submit() {
    if(this.todo.get('callsType').value === '' && this.type != 'Fun') {
      this.alert.present();
    }else{
      if(this.todo.get('type').value === 'Fun') {
        this.whistle = new Whistle();

        this.whistle.body = this.todo.get('body').value;
        this.whistle.author = this.todo.get('author').value;
        this.whistle.location = this.getLocation();
      }else {
        this.whistle = new Call();

        this.whistle.body = this.todo.get('body').value;
        this.whistle.author = this.todo.get('author').value;
        this.whistle.location = this.getLocation();
        this.whistle.callsType = this.todo.get('callsType').value;
      }

        this.whistleService.newWhistle(this.whistle).subscribe(() => {
          
          this.navCtrl.pop();
        });  
     
    }
  }

 
}
