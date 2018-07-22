import { Component } from '@angular/core';
import { IonicPage, Nav, NavController, Refresher, ToastController, LoadingController, InfiniteScroll, FabContainer} from 'ionic-angular';
import { PAGES } from '../pages';
import { URL } from '../../constants';
import { Whistle } from '../../model/whistle.model';
import { WhistleService } from '../../services/whistle.service';
import { Reaction } from '../../model/reaction.model';
import { UserService } from '../../services/user.service';
import { User } from '../../model/user.model';
import { TranslateService } from '../../../node_modules/@ngx-translate/core';

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  whistles: Array<Whistle>;
  reactions: Array<Reaction>;
  position_error: string;
  page = 0;

  constructor(public navCtrl: NavController,
              private nav: Nav,
              public whistleService: WhistleService,
              private toastCtrl: ToastController,
              private userService: UserService,
              public loadingCtrl: LoadingController,
              private translateService: TranslateService) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad HomePage');
    this.translateService.get('POSITION_DENIED_ERROR').subscribe((data) => {
      this.position_error = data;
    });
      const loader = this.loadingCtrl.create({
        content: "Please wait...",
        duration: 15000
      });
      loader.present();
    navigator.geolocation.getCurrentPosition((position) => {
    this.whistleService.list(position, this.page).subscribe((data: Array<Whistle>) => {
      loader.dismiss();
      this.whistles = data;
      console.log(data);
    });
  }, (error) => {
    loader.dismiss();
    this.showError(error);
  });
  }

  openDetails(w: Whistle) {
    this.navCtrl.push(PAGES.WHISTLE_DETAILS, {whistleId: w.id});
  }

  openComments(w: Whistle) {
    this.navCtrl.push(PAGES.COMMENTS, {whistleId: w.id});
  }

  filter(type: string, fab?: FabContainer) {
    console.log("filter");
    navigator.geolocation.getCurrentPosition((position) => {
      this.whistleService.list(position, this.page).subscribe((data: Array<Whistle>) => {
        switch(type) {
          case "Fun": {
            let result = Array<Whistle>();
            data.map((whistle) => {
              if(whistle.type === 'Fun') {
                result.push(whistle);
              }
            });
            this.whistles = result;
            break;
          }
          case "Call": {
            let result = Array<Whistle>();
            data.map((call) => {
              if(call.type === 'Call') {
                result.push(call);
              }
            });
            this.whistles = result;
            break;
          }
          case "All": {
            this.whistles = data;
            break;
          }
            
        }
        if(fab !== undefined) {
          fab.close();
        }    
      });
    });
  }

  createWhistle() {
    this.navCtrl.push(PAGES.WHISTLE);
  }

  react(w: Whistle) {
    
      if(!w.id_reaction) {           
        this.userService.getUser().subscribe((user: User) => {
          let reaction = new Reaction();
            reaction.whistle = w;
            reaction.reactionsOf = user; 
            this.whistleService.setReaction(reaction).subscribe((id) => {
              //w.reacted = true;
              w.id_reaction = id;            
              w.reactions++;
            });   
        }); 
      }else{
        this.whistleService.deleteReaction(w.id_reaction).subscribe(() => {
          //w.reacted = false;
          w.reactions--;
        });
      }
    
  }

  doRefresh(refresher: Refresher) {
    navigator.geolocation.getCurrentPosition((position) => {
      this.page = 0;
      this.whistleService.list(position, this.page).subscribe((data: Array<Whistle>) => {
      this.whistles = data;
      refresher.complete();
    });
  });
  }

  showError(error) {
    let err;
    switch(error.code) {            
        case error.PERMISSION_DENIED:
            err = this.position_error;
            break;
        case error.POSITION_UNAVAILABLE:
            err = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            err = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            err = "An unknown error occurred."
            break;
    }
    console.log(err); 
    
      let toast = this.toastCtrl.create({           
        message: err,
        duration: 10000
      });
      /*toast.present().then(() => {
        this.navCtrl.setRoot(PAGES.LOGIN);
      });*/
      this.nav.setRoot(PAGES.LOGIN);
      toast.present();
    } 

    loadMoreWhistles(infiniteScroll: InfiniteScroll) {
      console.log("load more");
      this.page ++;
      navigator.geolocation.getCurrentPosition((position) => {
      this.whistleService.list(position, this.page).subscribe((data: Array<Whistle>) => {
          this.whistles = this.whistles.concat(data);
          if(data.length == 0) {
              this.page --;
          }
          infiniteScroll.complete();       
      });
    });
  }


}


