import { NgModule } from "@angular/core";
import { IonicPageModule } from "ionic-angular";
import { TranslateModule } from "@ngx-translate/core";

import { WhistleDetailsPage } from "./whistle-details";

@NgModule({
    declarations: [
        WhistleDetailsPage
    ],
    imports: [
        IonicPageModule.forChild(WhistleDetailsPage),
        TranslateModule.forChild()
      ]
})
export class WhistleDetailsPageModule {}