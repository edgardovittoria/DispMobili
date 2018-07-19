import { Component } from "@angular/core";
import { IonicPage, Events } from "ionic-angular";
import { UserService } from "../../services/user.service";
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