import { Component } from "@angular/core";
import { IonicPage, AlertController, NavController } from "ionic-angular";
import { UserService } from "../../services/user.service";


@IonicPage()
@Component({
    selector: 'upload-user',
    templateUrl: 'upload.html'
})
export class UploadPage {
    img: File;

    constructor(private userService: UserService,
                private navCtrl: NavController,
                private alertCtrl: AlertController) {

    }

    upload() {
        this.userService.uploadProfileImg(this.img).subscribe(() => {
            let confirm = this.alertCtrl.create({
                title: "Image inserted",
                message: "Image uploaded successfully",
                buttons: [
                    {
                        text: "OK",
                        handler: () => {
                                this.navCtrl.pop();

                        }
                    }
                ]
            });
            confirm.present();
        });
    }
}