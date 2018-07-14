import { IonicPage, NavParams } from "ionic-angular";
import { Component } from "@angular/core";
import { Whistle } from "../../model/whistle.model";
import { Comment } from "../../model/comment.model";
import { WhistleService } from "../../services/whistle.service";

@IonicPage()
@Component({
    selector: 'page-comments',
    templateUrl: 'comments.html'
})
export class CommentsPage {
    whistle: Whistle;
    comments: Array<Comment>;

    constructor(public whistleService: WhistleService, public navParams: NavParams) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad CommentsPage');
        this.whistleService.findById(this.navParams.data.whistleId).subscribe((data: Whistle) => {
            this.whistle = data;
        });
        this.whistleService.getComments(this.navParams.data.whistleId).subscribe((data: Array<Comment>) => {
            this.comments = data;
        });
    }
}