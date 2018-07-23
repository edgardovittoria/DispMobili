import { IonicPage, NavController, NavParams, Nav } from "ionic-angular";
import { Component } from "@angular/core";
import { PAGES } from "../pages";
import { Whistle } from "../../model/whistle.model";
import { WhistleService } from "../../services/whistle.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";
import { Chat } from "../../model/chat.model";


@IonicPage()
@Component({
    templateUrl: 'whistle-details.html'
})
export class WhistleDetailsPage {
    whistle: Whistle;
    hide: boolean;


    constructor(public nav: Nav,
                private navCtrl: NavController, 
                public navParams: NavParams,
                public whistleService: WhistleService,
                private userService: UserService) {

    }

    newChat() {
        let newChat = new Chat();
        newChat.partecipant = this.whistle.author;
        this.nav.push(PAGES.CHAT, {chat: newChat});
    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad WhistleDetailsPage');
        this.whistleService.findById(this.navParams.data.whistleId).subscribe((data: Whistle) => {
          this.whistle = data;
          this.userService.getUser().subscribe((user: User)=> {
            if(this.whistle.author.id == user.id) {
                
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