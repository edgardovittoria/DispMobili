import { IonicPage, NavParams, InfiniteScroll } from "ionic-angular";
import { Component } from "@angular/core";
import { Whistle } from "../../model/whistle.model";
import { Comment } from "../../model/comment.model";
import { WhistleService } from "../../services/whistle.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";

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
                private userService: UserService
                /*private infiniteScroll: InfiniteScroll*/) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad CommentsPage');
        this.whistleService.findById(this.navParams.data.whistleId).subscribe((data: Whistle) => {
            this.whistle = data;
        });
        this.userService.getUser().subscribe((user: User) => {
            this.self = user;
        });
        this.whistleService.getComments(this.navParams.data.whistleId).subscribe((data: Array<Comment>) => {
            this.comments = data;
        });
        
    }


    loadMoreComments(infiniteScroll?) {
        if(this.page === 2) {
            infiniteScroll.enable(false);
        }
        this.page ++;
        this.whistleService.getComments(this.navParams.data.whistleId).subscribe((data: Array<Comment>) => {
            this.comments = this.comments.concat(data);
  
            if(InfiniteScroll) {
                infiniteScroll.complete();
            }
        })
    }

    
}