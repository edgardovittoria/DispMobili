import { IonicPage, NavController, NavParams } from "ionic-angular";
import { Component } from "@angular/core";
import { PAGES } from "../pages";
import { Whistle } from "../../model/whistle.model";
import { WhistleService } from "../../services/whistle.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";


@IonicPage()
@Component({
    templateUrl: 'whistle-details.html'
})
export class WhistleDetailsPage {
    whistle: Whistle;
    hide: boolean;


    constructor(public navCtrl: NavController, 
                public navParams: NavParams,
                public whistleService: WhistleService,
                private userService: UserService) {

    }

    newChat() {
        this.navCtrl.push(PAGES.CHAT, {userId: this.whistle.author.id});
    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad WhistleDetailsPage');
        this.whistleService.findById(this.navParams.data.whistleId).subscribe((data: Whistle) => {
          this.whistle = data;
          this.userService.getUser().subscribe((user: User)=> {
              console.log("user");
              console.log(user);
            if(this.whistle.author.id == user.id) {
                console.log("if");
                //document.getElementById("submit").setAttribute( "hidden", "hidden");
                this.hide = true;
            }
            });
        });
        
      }

      delete(){
        this.whistleService.deleteWhistle(this.whistle).subscribe(()=>{
            this.navCtrl.pop();
        });
      }
      
      update() {

      }
}