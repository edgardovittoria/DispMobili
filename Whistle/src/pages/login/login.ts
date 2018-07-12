import { IonicPage, NavController, Events, AlertController } from "ionic-angular";
import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from '../../../node_modules/@angular/forms';
import { Account, UserService } from '../../services/user.service';
import { User } from "../../model/user.model";
import { HttpErrorResponse } from "../../../node_modules/@angular/common/http";
import { PAGES } from "../pages";

@IonicPage()
@Component({
    selector: 'page-login',
    templateUrl: 'login.html'
})
export class LoginPage {
    account: Account = {username: "pippo", password: "password"};
    todo : FormGroup;

    constructor( private formBuilder: FormBuilder,
                 public userService: UserService,
                 public events: Events,
                public alertCtrl: AlertController) {
        this.todo = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
          });
    }

    logForm() {
        console.log(this.todo.value)
    }  

    submit() {
        this.userService.login(this.account)
        .subscribe((utente: User) => {
          this.events.publish('login', utente);
        },
          (err: HttpErrorResponse) => {
            if (err.status == 404) {
              console.error('login request error: ' + err.status);
              this.showLoginError();
            }
          });
    }


    showLoginError() {
      let alert = this.alertCtrl.create({
        title: "errore",
        subTitle: "boh",
        buttons: ['OK']
      });
      alert.present();
    }
}


/*account: Account = { username: "pippo", password: "baudo" };
    todo : FormGroup;

    constructor(public navCtrl: NavController, 
                public formBuilder: FormBuilder, 
                public userService: UserService,
                public events: Events,
                public alertCtrl: AlertController) { 
          
          this.todo = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
          });
    
          
      }

    logForm() {
        console.log(this.todo.value)
    }  

    submit() {
        this.userService.login(this.account)
            .subscribe((utente: User) => {
              this.events.publish('login', utente);
            },
              (err: HttpErrorResponse) => {
                if (err.status == 401) {
                  console.error('login request error: ' + err.status);
                  this.showLoginError();
                }
              });
        
    }
    
      /*showLoginError() {
        console.log("spacciati");
      }*/