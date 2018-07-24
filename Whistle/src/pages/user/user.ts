import { Component } from "@angular/core";
import { IonicPage, Events, ModalController } from "ionic-angular";
import { UserService } from "../../services/user.service";
import { PAGES } from '../pages';
import { User } from "../../model/user.model";

@IonicPage()
@Component({
    selector: 'page-user',
    templateUrl: 'user.html'
})
export class UserPage {
    user: User;
    hide: boolean = true;

    constructor(public events: Events, 
                public modalCtrl: ModalController,
                private userService: UserService) {

    }

    ionViewDidLoad() {
        console.log("ionViewDidLoad UserPage");
        this.userService.getUser().subscribe((user: User) => {
          this.user = user;
        });
      }

      fabControl() {
        if(!this.hide) {
          this.hide = true;
        }
      }


      setImage() {
        let modal = this.modalCtrl.create(PAGES.UPLOAD);
        modal.onDidDismiss(() => {  
        });
        modal.present();
        }

      setDescription() {
        this.hide = false;
        document.getElementById('input').focus();
      }

      update() {
        this.userService.updateUser(this.user).subscribe(()=> {
          this.hide = true;
        });
      }

}