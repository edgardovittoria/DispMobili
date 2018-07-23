import { IonicPage, NavParams, InfiniteScroll, Refresher, NavController, AlertController, ItemSliding} from "ionic-angular";
import { Component } from "@angular/core";
import { Whistle } from "../../model/whistle.model";
import { Comment } from "../../model/comment.model";
import { WhistleService } from "../../services/whistle.service";
import { UserService } from "../../services/user.service";
import { User } from "../../model/user.model";
import { PAGES } from "../pages";
//import { AlertController } from "ionic-angular";

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
                private navCtrl: NavController,
                private alertCtrl: AlertController
                /*private refresher: Refresher*/) {

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
            this.comments = this.setAuthor(data);
        });
    }

    setAuthor(array: Array<Comment>) {
        array.map((c: Comment) => {
            if (c.author.id === this.self.id) {
                c.mine = true;
            } else {
                c.mine = false;
            }
        });
        return array;
    }

    submit() {
        this.comment.date = new Date();
            let confirm = this.alertCtrl.create({
                title: "Comment inserted",
                message: "To see the message, reload the page.",
                buttons: [
                  {
                    text: "OK",
                    handler: () => {
                        this.whistleService.newComment(this.comment).subscribe(() => {
                            let newComment = new Comment();
                            newComment = this.comment;
                            this.comments.push(newComment);
                            this.comment.body = '';
                      });
          
                    }
                  }
                ]
              });
              confirm.present();
            
    
    }

    delete(c: Comment){

            let confirm = this.alertCtrl.create({
                title: "Delete comment",
                message: "Comment will be deleted. Proceed?.",
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
                        this.whistleService.deleteComment(c).subscribe(()=>{
                            let index = this.comments.indexOf(c);
                            this.comments.splice(index,1);
                      });
          
                    }
                  }
                ]
              });
              confirm.present();
            
        
    }

    update(c: Comment){
        /*this.comment.body = c.body;
        this.whistleService.updateComment(c).subscribe(()=>{
            //this.comment.body = c.body;
        });*/
    }


    loadMoreComments(infiniteScroll: InfiniteScroll) {
        console.log("load more");
        this.page ++;
        this.whistleService.getComments(this.navParams.data.whistleId, this.page).subscribe((data: Array<Comment>) => {
            this.comments = this.comments.concat(this.setAuthor(data));
            if(data.length == 0) {
                this.page --;
                infiniteScroll.enable(false);
            }
            infiniteScroll.complete();
        });
    }

    doRefresh(refresher: Refresher) {
        this.page = 0;
        this.whistleService.getComments(this.whistle.id, this.page).subscribe((data: Array<Comment>) => {
            this.comments = this.setAuthor(data);
            refresher.complete();
        });
    }
    
}