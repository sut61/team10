import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import{Controller}from'../controller/controller';
@Component({
  selector: 'app-reservation-photographer',
  templateUrl: './reservation-photographer.component.html',
  styleUrls: ['./reservation-photographer.component.css']
})
export class ReservationPhotographerComponent implements OnInit {
  mems: Array<any>;
  memSelect=null;
  photos: Array<any>;
  photoSelect=null;
  typephotos: Array<any>;
  typephotoSelect=null;
  promotionphotos: Array<any>;
  promotionphotoSelect=null;
  starttimes: Array<any>;
  starttimeSelect = null;
  finaltimes : Array<any>;
  finaltimeSelect = null;
  comment:String;
  comments : Array<any>;
  time = null;
  data:any={}
  constructor(private controller:Controller,private httpClient: HttpClient,
  private router:Router,private route:ActivatedRoute) {}

  ngOnInit() {

    this.controller.getComment().subscribe(data => {
      this.comments = data;
      console.log(this.comments);
    });
    this.controller.getMember().subscribe(data => {
      this.mems = data;
      console.log(this.mems);
    });

    this.controller.getPhotographer().subscribe(data => {
      this.photos = data;
      console.log(this.photos);
    });

    this.controller.getTypePhoto().subscribe(data => {
      this.typephotos = data;
      console.log(this.typephotos);
    });

    this.controller.getPromotionPhotographer().subscribe(data => {
      this.promotionphotos = data;
      console.log(this.promotionphotos);
    });

    this.controller.getStartTime().subscribe(data => {
      this.starttimes = data;
      console.log(this.starttimes);
    });
    this.controller.getFinalTime().subscribe(data => {
      this.finaltimes = data;
      console.log(this.finaltimes);
    });
    this.route.params.subscribe(prams=>{
                      this.data = prams
                      console.log(prams)
                    })

  }
  enter(){
    if(this.photoSelect == null || this.typephotoSelect == null || this.promotionphotoSelect == null
    || this.starttimeSelect == null || this.finaltimeSelect == null || this.comment == null ) {
      alert('กรุณาใส่ข้อมูลให้ครบ');

    }else if(this.promotionphotoSelect != (this.finaltimeSelect-this.starttimeSelect)){
      alert('เลือกเวลาให้ถูกต้อง');
    }
    else if(this.time == null) {
      alert('กรุณาเลือกวันที่จอง');
    }
    else{
      this.httpClient.post('http://localhost:8080/reservationPhotographer/' +this.data.first+ '/' +this.photoSelect
        + '/' +this.typephotoSelect+ '/' +this.promotionphotoSelect+'/'+this.starttimeSelect+'/'+this.finaltimeSelect+'/'+this.time
        +'/'+this.comment,{})
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }
        );
      alert("สำเร็จ");
      window.location.reload()
    }
  }
       home(){
               this.router.navigate(['home',{first:this.data.first}]);
               console.log(this.data);
            }
            studio(){
                 this.router.navigate(['reservation-studio',{first:this.data.first}]);
                 console.log(this.data);
              }

            equipment(){
                   this.router.navigate(['reservation-equipment',{first:this.data.first}]);
                   console.log(this.data);
                }
             photo(){
                               this.router.navigate(['reservation-photographer',{first:this.data.first}]);
                               console.log(this.data);
                            }
          collect(){
                          this.router.navigate(['photocollection',{first:this.data.first}]);
                          console.log(this.data);
                       }
                        model(){
                                         this.router.navigate(['reservation-model',{first:this.data.first}]);
                                                             console.log(this.data);
                            }
}

