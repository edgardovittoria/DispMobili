import { NgModule } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { IonicPageModule } from 'ionic-angular';

import { WhistlePage } from './new-whistle';

@NgModule({
  declarations: [
    WhistlePage,
  ],
  imports: [
    IonicPageModule.forChild(WhistlePage),
    TranslateModule.forChild()
  ],
})
export class WhistlePageModule {}