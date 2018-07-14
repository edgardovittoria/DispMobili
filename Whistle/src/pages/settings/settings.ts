import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { LanguageService, Language } from '../../services/language.service';
import { UserService } from '../../services/user.service';
import { User } from '../../model/user.model';
import { TranslateService } from '../../../node_modules/@ngx-translate/core';

@IonicPage()
@Component({
  selector: 'page-settings',
  templateUrl: 'settings.html'
})
export class SettingsPage {
    audio: boolean;
    user: User;
    bestLang: string;
    langs: Array<Language>;
        
    constructor(private navCtrl: NavController,
                private translateService: TranslateService,
                private languageService: LanguageService,
                private userService: UserService) {

    }
    
    
    ionViewDidLoad() {
        console.log("ionViewDidLoad SettingsPage");
        this.langs = this.languageService.getLangs();
        this.languageService.getCurrLang().subscribe((lang: string) => {
          this.bestLang = lang;
        });
        this.userService.getUser().subscribe((user: User) => {
          this.user = user;
        });
      }

    submit() {
          this.translateService.use(this.bestLang);
          this.languageService.updateLang(this.bestLang);
          this.userService.updateUser(this.user).subscribe((newUser: User) => {
            this.user = newUser;
            this.navCtrl.pop();
          });  
    } 
}
