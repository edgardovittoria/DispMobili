import { IonicPage, NavParams, InfiniteScroll, Refresher, AlertController } from "ionic-angular";
import { Component } from "@angular/core";
import { Whistle } from "../../model/whistle.model";
import { Comment } from "../../model/comment.model";
import { WhistleService } from "../../services/whistle.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";
import { TranslateService } from "../../../node_modules/@ngx-translate/core";

@IonicPage()
@Component({
    selector: 'page-comments',
    templateUrl: 'comments.html'
})
export class CommentsPage {
    alertTitle: string;
    alertSubTitle: string;
    page = 0;
    self: User;
    whistle: Whistle;
    comment: Comment = new Comment();
    comments: Array<Comment>;

    constructor(public whistleService: WhistleService,
        public navParams: NavParams,
        private userService: UserService,
        private alertCtrl: AlertController,
        private translateService: TranslateService) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad CommentsPage');
        this.translateService.get('DELETE_ALERT_SUBTITLE').subscribe((data) => {
            this.alertSubTitle = data;
          });
          this.translateService.get('DELETE_ALERT_TITLE').subscribe((data) => {
            this.alertTitle = data;
          });
        this.whistleService.findById(this.navParams.data.whistleId).subscribe((w: Whistle) => {
            this.whistle = w;
            this.comment.id_whistle = w;
        });
        this.userService.getUser().subscribe((user: User) => {
            this.self = user;
            this.comment.author = user;
        });
        this.whistleService.getComments(this.navParams.data.whistleId, this.page).subscribe((data: Array<Comment>) => {
            this.comments = this.mapComments(data);
        });
    }

    mapComments(array: Array<Comment>) {
        array.map((c: Comment) => {
            let date = new Date(c.date);
            c.time = date.toLocaleDateString() + ", " + date.getHours() +":"+ date.getMinutes();
            if (c.author.id === this.self.id) {
                c.mine = true;
            } else {
                c.mine = false;
            }
        });
        return array;
    }

    submit() {
        let date = new Date();
        this.comment.date = date.getTime();
        this.whistleService.newComment(this.comment).subscribe((id: number) => {
            let newComment = new Comment();
            newComment.author = this.comment.author;
            newComment.body = this.comment.body;
            newComment.time = date.toLocaleDateString() + ", " + date.getHours() +":"+ date.getMinutes();
            newComment.id_whistle = this.comment.id_whistle;
            newComment.id = id;
            newComment.mine = true;
            this.comments.push(newComment);
            this.comment.body = '';
        });
    }

    delete(c: Comment) {

        let confirm = this.alertCtrl.create({
            title: this.alertTitle,
            message: this.alertSubTitle,
            buttons: [
                {
                    text: "CANCEL",
                    handler: () => {
                        console.log('Annulla clicked');
                    }
                },
                {
                    text: "OK",
                    handler: () => {
                        this.whistleService.deleteComment(c).subscribe(() => {
                            let index = this.comments.indexOf(c);
                            this.comments.splice(index, 1);
                        });

                    }
                }
            ]
        });
        confirm.present();


    }


    loadMoreComments(infiniteScroll: InfiniteScroll) {
        console.log("load more");
        this.page++;
        this.whistleService.getComments(this.navParams.data.whistleId, this.page).subscribe((data: Array<Comment>) => {
            this.comments = this.comments.concat(this.mapComments(data));
            if (data.length == 0) {
                this.page--;
                infiniteScroll.enable(false);
            }
            infiniteScroll.complete();
        });
    }

    doRefresh(refresher: Refresher) {
        this.page = 0;
        this.whistleService.getComments(this.whistle.id, this.page).subscribe((data: Array<Comment>) => {
            this.comments = this.mapComments(data);
            refresher.complete();
        });
    }

}