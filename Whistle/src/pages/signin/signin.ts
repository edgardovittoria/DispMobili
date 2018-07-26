import { IonicPage, Events, AlertController, NavController} from "ionic-angular";
import { Component } from "@angular/core";
import { Account, UserService } from '../../services/user.service';
import { User } from "../../model/user.model";
import { HttpErrorResponse } from "../../../node_modules/@angular/common/http";
import { TranslateService } from "../../../node_modules/@ngx-translate/core";
import { NgForm } from '@angular/forms';
import { PAGES } from "../pages";

@IonicPage()
@Component({
    selector: 'page-signin',
    templateUrl: 'signin.html'
})
export class SigninPage {
    account: Account = {name: "", surname: "", username: "", email: "", password: ""};
    confermaPassword: String = "";
    /*s
    loginTitle: string;
    loginSubTitle: string;*/

    constructor(public userService: UserService,
                public events: Events,
                public alertCtrl: AlertController,
                public navCtrl: NavController,
                private translateService: TranslateService) {
           
    }

    submit(form: NgForm) {
        if (form.valid && this.account.password === this.confermaPassword) { 
          this.userService.signin(this.account).subscribe(()=>{
              this.navCtrl.push(PAGES.LOGIN);
          });
        }else{
            this.showSigninError();
        }
      }
    
    
    
    showSigninError() {
        let alert = this.alertCtrl.create({
          title: "ERRORE",
          subTitle: "Controllare i campi inseriti",
          buttons: ['OK']
        });
        alert.present();
      }

    }      