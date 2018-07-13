import { Injectable } from "../../node_modules/@angular/core";
import { HttpClient } from "../../node_modules/@angular/common/http";
import { ToastController } from "ionic-angular";
import { URL } from '../constants';
import { Account, UserService } from '../services/user.service';


export class UserLocation {
    user: Account;
    latitude: number;
    longitude: number;
}

@Injectable()
export class PositionService { 

    account: Account;
    mylocation: any;
    

    constructor(private http: HttpClient, public toastCtrl: ToastController) {

    }

    setAccount(acc: Account) {
        this.account = acc;
    }

    getPosition() {
        navigator.geolocation.getCurrentPosition(this.sendUserPosition, this.showError);
    }

    sendPosition(position) {
        return this.http.post<Geolocation>(URL.STORE.POSITION, position.coords);  
    }

    sendUserPosition(position) {
        let usLoc: UserLocation = {user: this.account, latitude: position.coords.latitude, longitude: position.coords.longitude};
        return this.http.post<UserLocation>(URL.STORE.POSITION, usLoc);  
    }

    showError(error) {
        let err;
        switch(error.code) {            
            case error.PERMISSION_DENIED:
                err = "User denied the request for Geolocation."
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
        toast => {
            toast = this.toastCtrl.create({           
            message: err,
            duration: 3000
          });
          toast.present();
        }
    } 

}