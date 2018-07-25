import {Component} from '@angular/core';
//import {throwError} from "rxjs";
import {Loading, LoadingController, ToastController, IonicPage, NavController} from "ionic-angular";
import {Camera} from '@ionic-native/camera';
import {File, FileEntry} from "@ionic-native/file";
import { catchError } from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import { URL } from '../../constants';

@IonicPage()
@Component({
  selector: 'page-upload',
  templateUrl: 'upload.html'
})
export class UploadPage {
  public myPhoto: any;
  public error: string;
  private loading: Loading;

  constructor(private readonly http: HttpClient,
              private readonly loadingCtrl: LoadingController,
              private navCtrl: NavController,
              private readonly toastCtrl: ToastController,
              private readonly camera: Camera,
              private readonly file: File) {
  }

  takePhoto() {
    this.camera.getPicture({
      quality: 100,
      destinationType: this.camera.DestinationType.FILE_URI,
      sourceType: this.camera.PictureSourceType.CAMERA,
      encodingType: this.camera.EncodingType.JPEG
    }).then(imageData => {
      this.myPhoto = imageData;
      this.uploadPhoto(imageData);
    }, error => {
      this.error = JSON.stringify(error);
    });
  }

  selectPhoto(): void {
    this.camera.getPicture({
      sourceType: this.camera.PictureSourceType.PHOTOLIBRARY,
      destinationType: this.camera.DestinationType.FILE_URI,
      quality: 100,
      encodingType: this.camera.EncodingType.PNG,
    }).then(imageData => {
      this.myPhoto = imageData;
      this.uploadPhoto(imageData);
    }, error => {
      this.error = JSON.stringify(error);
    });
  }

  private uploadPhoto(imageFileUri: any): void {
    this.error = null;
    this.loading = this.loadingCtrl.create({
      content: 'Uploading...'
    });

    this.loading.present();

    this.file.resolveLocalFilesystemUrl(imageFileUri)
      .then(entry => (<FileEntry>entry).file(file => this.readFile(file)))
      .catch(err => console.log(err));
  }

  private readFile(file: any) {
    console.log("readFile");
    const reader = new FileReader();
    reader.onloadend = () => {
      const formData = new FormData();
      const imgBlob = new Blob([reader.result], {type: file.type});
      formData.append('file', imgBlob, file.name);
      console.log("Onloadend");
      this.postData(formData);
    };
    reader.readAsArrayBuffer(file);
  }

  private postData(formData: FormData) {
      //let url = "http://localhost:8080/whistle/api/upload";
      console.log("postData");
      console.log(formData);
    this.http.post<boolean>(URL.UPLOAD, formData).subscribe(ok => {
        this.loading.dismiss();
        this.showToast(ok)
    },
        catchError(e => this.handleError(e)));
  }

  private showToast(ok: any) {
    if (ok) {
        console.log(ok);
      const toast = this.toastCtrl.create({
        message: 'Upload successful',
        duration: 3000,
        position: 'top'
      });
      toast.present();
    }
    else {
      const toast = this.toastCtrl.create({
        message: 'Upload failed',
        duration: 3000,
        position: 'top'
      });
      toast.present();
    }
  }

  private handleError(error: any) {
    const errMsg = error.message ? error.message : error.toString();
    this.error = errMsg;
    return errMsg;
  }

  closeModal() {
    this.navCtrl.pop();
}

}