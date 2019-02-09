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
  comment:String;
  point:String;
  phone:String;
  email:String;
  price:number;
  prices: Array<any>;
  points : Array<any>;
  phones : Array<any>;
  emails : Array<any>;
  comments : Array<any>;
  time = null;
  data:any={}
  constructor(private controller:Controller,private httpClient: HttpClient,
  private router:Router,private route:ActivatedRoute) {}

  ngOnInit() {
    this.controller.getComment().subscribe(data => {
      this.prices = data;
      console.log(this.prices);
    });
    this.controller.getComment().subscribe(data => {
      this.points = data;
      console.log(this.points);
    });
    this.controller.getComment().subscribe(data => {
      this.phones = data;
      console.log(this.phones);
    });
    this.controller.getComment().subscribe(data => {
      this.emails = data;
      console.log(this.emails);
    });
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

    this.route.params.subscribe(prams=>{
                      this.data = prams
                      console.log(prams)
                    })

  }
  enter(){
    if(this.photoSelect == null || this.typephotoSelect == null || this.promotionphotoSelect == null || this.price == null
    || this.starttimeSelect == null  || this.comment == null || this.point == null || this.phone == null || this.email == null) {
      alert('กรุณาใส่ข้อมูลให้ครบ');
    }else if(this.promotionphotoSelect != this.starttimeSelect){
      alert('กรุณาเลือกโปรโมชั่นและเวลาให้ตรงกัน')
    }
    else if(this.time == null) {
      alert('กรุณาเลือกวันที่จอง');
    }           else if(this.price < 1000) {
      alert('กรุณากรอกราคาให้ถูกต้อง');
    }
    else if(this.price > 3000) {
      alert('กรุณากรอกราคาให้ถูกต้อง');
    }
    else{
      this.httpClient.post('http://localhost:8080/reservationPhotographer/' +this.data.first+ '/' +this.photoSelect
        + '/' +this.typephotoSelect+ '/' +this.promotionphotoSelect+'/'+this.starttimeSelect+'/'+this.time
        +'/'+this.point+'/'+this.price+'/'+this.phone+'/'+this.email+'/'+this.comment,{})
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }
        );
      alert("สำเร็จ");
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
payment(){
         this.router.navigate(['payonline',{first:this.data.first}]);
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
registerPhotography(){
        this.router.navigate(['register-photography',{first:this.data.first}]);
        console.log(this.data);
    }
  review(){
    this.router.navigate(['review',{first:this.data.first}]);
    console.log(this.data);
  }
}

