import { IonicPage, Events, AlertController } from "ionic-angular";
import { Component } from "@angular/core";
import { Account, UserService } from '../../services/user.service';
import { User } from "../../model/user.model";
import { HttpErrorResponse } from "../../../node_modules/@angular/common/http";

@IonicPage()
@Component({
    selector: 'page-login',
    templateUrl: 'login.html'
})
export class LoginPage {
    account: Account = {username: "federap", password: "pluto"};

    constructor(public userService: UserService,
                public events: Events,
                public alertCtrl: AlertController) {
           
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
        title: "Error",
        subTitle: "invalid password and/or username",
        buttons: ['OK']
      });
      alert.present();
    }
}
