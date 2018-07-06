import { Component, ViewChild } from '@angular/core';
import { Platform, Nav, Events } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { User } from '../model/user.model';
//import { TranslateService } from '@ngx-translate/core';

import { PAGES } from '../pages/pages';
//import { UserService } from '../services/user.service';
import { LanguageService } from '../services/language.service';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage: any; //questo credo seleziona la pagina iniziale
  user: User;

  @ViewChild(Nav) nav: Nav;

  constructor(public events: Events, platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen,
    /* private translate: TranslateService, private userService: UserService,*/ private langService: LanguageService) {
    //this.initTranslate();
    //this.subscribeToEvents();
    
    platform.ready().then(() => {
      //userService.getUser().subscribe((user: User) => {
        let pippo = 'pippo'; //new User('pippo','pippo@gmail','password');
        if (pippo == null) {
          //this.user = pippo;       
          this.rootPage = PAGES.LOGIN;
        } else {          
          this.rootPage = PAGES.TABS;
        }
      //});
      statusBar.styleDefault();
      splashScreen.hide();
    });

  }

  /*initTranslate() {
    // Set the default language for translation strings, and the current language.
    let BestLang = this.langService.getBestLang();
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
    this.nav.setRoot(LOGIN_PAGE);
  }

  subscribeToEvents() {
    this.events.subscribe('login', (user: User) => {
      this.user = user;
      
      //this.nav.setRoot(TABS_PAGE);
    });
  }*/
}

