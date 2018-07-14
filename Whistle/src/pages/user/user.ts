import { Component } from "@angular/core";
import { IonicPage, Events } from "ionic-angular";
import { TranslateService } from "@ngx-translate/core";
import { UserService } from "../../services/user.service";
import { PAGES } from "../pages";
import { LanguageService, Language } from "../../services/language.service";
import { User } from "../../model/user.model";

@IonicPage()
@Component({
    selector: 'page-user',
    templateUrl: 'user.html'
})
export class UserPage {
    user: User;
    bestLang: string;
    langs: Array<Language>;

    constructor(public events: Events, 
                private userService: UserService,
                private translateService: TranslateService,
                private languageService: LanguageService) {

    }

    /*ionViewDidLoad() {
        console.log("ionViewDidLoad UserPage");
        this.langs = this.languageService.getLangs();
        this.languageService.getCurrLang().subscribe((lang: string) => {
          this.bestLang = lang;
        });
        this.userService.getUser().subscribe((user: User) => {
          this.user = user;
        });
      }

      onSubmit(form: NgForm) {
        if (form.valid) {
          this.translateService.use(this.bestLang);
          this.languageService.updateLang(this.bestLang);
          this.userService.updateProfilo(this.utente).subscribe((newUser: User) => {
            this.user = newUser;
            this.navCtrl.pop();
          });
    
        }
      }  */

}