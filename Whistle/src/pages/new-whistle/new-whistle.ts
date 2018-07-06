import { Component } from '@angular/core';
import { IonicPage} from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-new-whistle',
  templateUrl: 'new-whistle.html'
})

export class WhistlePage {
  type: string = 'Fun';
  callTypes: string;

  submit() {
    
  }
}
