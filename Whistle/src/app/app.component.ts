import { Component, ViewChild } from '@angular/core';
import { Platform, Nav, Events, AlertController, MenuController } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { User } from '../model/user.model';
import { TranslateService } from '@ngx-translate/core';

import { PAGES } from '../pages/pages';
import { UserService } from '../services/user.service';
import { LanguageService } from '../services/language.service';
import { HttpErrorResponse } from '../../node_modules/@angular/common/http';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage: any; //questo credo seleziona la pagina iniziale
  user: User;

  @ViewChild(Nav) nav: Nav;

  constructor(public events: Events, 
              platform: Platform, 
              statusBar: StatusBar, 
              splashScreen: SplashScreen,
              private menu: MenuController,
              private alertCtrl: AlertController,
              private translate: TranslateService,
              private userService: UserService, 
              private langService: LanguageService) {
    
    console.log("constructor MyApp");
    this.initTranslate();
    this.subscribeToEvents();
    
    platform.ready().then(() => {
      userService.getUser().subscribe((user: User) => {
        if (user != null) {
          this.user = user;
          this.enableMenu(true);
          this.rootPage = PAGES.TABS;
        } else {
          this.rootPage = PAGES.SIGNIN;
        }
      });
      statusBar.styleDefault();
      splashScreen.hide();
    });

  }

  initTranslate() {
    // Set the default language for translation strings, and the current language.
    let BestLang = this.langService.getBestLang();
    console.log("pippo");
    this.translate.setDefaultLang(BestLang);
    this.langService.getCurrLang().subscribe((lang: string) => {
      if (lang != null) {
        this.translate.use(lang);
      } else {
        this.translate.use(BestLang);
        this.langService.updateLang(BestLang);
      }
    });
  } 

  logout() {
    this.userService.logout();
    this.enableMenu(false); 
    this.nav.setRoot(PAGES.LOGIN);
  }

  openPage(page) {
    this.nav.push(page);
    this.menu.close();
  }

  subscribeToEvents() {
    this.events.subscribe('login', (user: User) => {
      this.user = user;
      this.enableMenu(true);    
      this.nav.setRoot(PAGES.TABS);
    });
  }

  enableMenu(loggedIn: boolean) {
    this.menu.enable(loggedIn);
  }

  showMessageServerError(err: HttpErrorResponse) {
    let errorMessage = "Errore nel server";

    switch (err.status) {
      case 403:
        errorMessage = "Utente non autorizzato";
        break;
      case 401:
        errorMessage = "Utente non autenticato";
        break;
      default:
        errorMessage = `Errore: ${err.status}`;
    }
    let alert = this.alertCtrl.create({
      title: "Errore",
      subTitle: errorMessage,
      buttons: [
        {
          text: 'Ok',
          handler: () => {
            this.userService.logout();
            this.nav.setRoot(PAGES.LOGIN);
          }
        }
      ]
    });
    alert.present();
  }
}

