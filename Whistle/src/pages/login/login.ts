import { IonicPage, Events, AlertController } from "ionic-angular";
import { Component } from "@angular/core";
import { Account, UserService } from '../../services/user.service';
import { User } from "../../model/user.model";
import { HttpErrorResponse } from "../../../node_modules/@angular/common/http";
import { TranslateService } from "../../../node_modules/@ngx-translate/core";

@IonicPage()
@Component({
    selector: 'page-login',
    templateUrl: 'login.html'
})
export class LoginPage {
    account: Account = {username: "federap", password: "pluto"};

    loginTitle: string;
    loginSubTitle: string;

    constructor(public userService: UserService,
                public events: Events,
                public alertCtrl: AlertController,
                private translateService: TranslateService) {
           
    }

    ionViewDidLoad() {
      console.log('ionViewDidLoad LoginPage');
      this.translateService.get('LOGIN_ERROR_SUB_TITLE').subscribe((data) => {
        this.loginSubTitle = data;
      });
      this.translateService.get('LOGIN_ERROR_TITLE').subscribe((data) => {
        this.loginTitle = data;
      });
    }

    submit() {
        this.userService.login(this.account)
        .subscribe((user: User) => {         
          this.events.publish('login', user);          
        },
          (err: HttpErrorResponse) => {
            if (err.status == 401) {
              console.error('login request error: ' + err.status);
              this.showLoginError();
            }
          });
    }


    showLoginError() {
      let alert = this.alertCtrl.create({
        title: this.loginTitle,
        subTitle: this.loginSubTitle,
        buttons: ['OK']
      });
      alert.present();
    }
}
