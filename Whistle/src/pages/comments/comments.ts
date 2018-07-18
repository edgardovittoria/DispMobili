import { IonicPage, NavParams, InfiniteScroll, Refresher, NavController } from "ionic-angular";
import { Component } from "@angular/core";
import { Whistle } from "../../model/whistle.model";
import { Comment } from "../../model/comment.model";
import { WhistleService } from "../../services/whistle.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";
import { PAGES } from "../pages";

@IonicPage()
@Component({
    selector: 'page-comments',
    templateUrl: 'comments.html'
})
export class CommentsPage {
    page = 0;
    self: User;
    whistle: Whistle;
    comment: Comment = new Comment();
    comments: Array<Comment>;

    constructor(public whistleService: WhistleService, 
                public navParams: NavParams,
                private userService: UserService,
                private navCtrl: NavController
                /*private refresher: Refresher
                /*private infiniteScroll: InfiniteScroll*/) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad CommentsPage');
        this.whistleService.findById(this.navParams.data.whistleId).subscribe((w: Whistle) => {
            this.whistle = w;
            this.comment.id_whistle = w;
        });
        this.userService.getUser().subscribe((user: User) => {
            this.self = user;
            this.comment.author = user;
        });
        this.whistleService.getComments(this.navParams.data.whistleId, this.page).subscribe((data: Array<Comment>) => {
            this.comments = data;
        });
        
    }

    submit() {
        this.comment.date = new Date();
        this.whistleService.newComment(this.comment).subscribe(() => {
            let newComment = this.comment;
            this.comments.push(newComment);
            this.comment.body = '';
        });
    }


    loadMoreComments(infiniteScroll: InfiniteScroll) {
        console.log("load more");
        /*if(this.page === 5) {
            infiniteScroll.enable(false);
        }*/
        this.page ++;
        this.whistleService.getComments(this.navParams.data.whistleId, this.page).subscribe((data: Array<Comment>) => {
            this.comments = this.comments.concat(data);
            if(data.length == 0) {
                this.page --;
            }
            infiniteScroll.complete();
            
        })
    }
    
}