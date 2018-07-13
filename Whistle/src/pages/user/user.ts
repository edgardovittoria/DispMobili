import { Component } from "@angular/core";
import { IonicPage, Events } from "ionic-angular";
import { TranslateService } from "@ngx-translate/core";
import { UserService } from "../../services/user.service";
import { PAGES } from "../pages";

@IonicPage()
@Component({
    selector: 'page-user',
    templateUrl: 'user.html'
})
export class UserPage {

    constructor(public events: Events) {

    }

}