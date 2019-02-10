import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";
@Component({
  selector: 'app-reservation-studio',
  templateUrl: './reservation-studio.component.html',
  styleUrls: ['./reservation-studio.component.css']
})
export class ReservationStudioComponent implements OnInit {
  roomStudios : Array<any>;
  roomStudioSelect= null;
  data:any={}
  promotionStudios : Array<any>;
  promotionStudioSelect= null;

  timeStudios : Array<any>
  timeStudioSelect= null;

  reservationDates = null ;

  priceNew = null;

  reservationStudio : Array<any>;

   constructor(private controller:Controller,private httpClient: HttpClient,public dialog: MatDialog,
    private route:ActivatedRoute,private router:Router,) { }
  ngOnInit() {
      this.controller.getRoomStudio().subscribe(data => {
                    this.roomStudios = data;
                    console.log(this.roomStudios);
                 });
      this.controller.getPromotionStudio().subscribe(data => {
                     this.promotionStudios = data;
                     console.log(this.promotionStudios);
                 });
      this.controller.getTimeStudio().subscribe(data => {
                     this.timeStudios = data;
                     console.log(this.timeStudios);
                 });
      this.controller.getReservationStudio().subscribe(data => {
                     this.reservationStudio = data;
                     console.log(this.reservationStudio);
                 });
       this.route.params.subscribe(prams=>{
                    this.data = prams
                    console.log(prams)
                  })


  }
   reset(){
          this.roomStudioSelect=null;
          this.promotionStudioSelect=null;
          this.timeStudioSelect=null;
          this.reservationDates=null;
          this.priceNew = null;
    }

   insert() {
           if (this.roomStudioSelect == null) {
                alert('กรุณาเลือกสตูดิโอ');
           }
           else if(this.promotionStudioSelect == null) {
                alert('กรุณาเลือกโปรโมชั่น');
           }
           else if(this.timeStudioSelect == null) {
                alert('กรุณาเลือกช่วงเวลา');
           }
           else if(this.reservationDates == null) {
                alert('กรุณาเลือกวันที่จอง');
           }
           else if(this.priceNew == null) {
                 alert('กรุณากรอกราคา');
           }
           else if(this.priceNew < 1000) {
                 alert('กรุณากรอกราคาให้ถูกต้อง');
           }
           else if(this.priceNew > 2000) {
                 alert('กรุณากรอกราคาให้ถูกต้อง');
           }
           else{
                this.httpClient.post('http://localhost:8080/reservationStudio/' + this.roomStudioSelect + '/' + this.promotionStudioSelect + '/'
                  + this.timeStudioSelect + '/' + this.reservationDates + '/' + this.data.first + '/' + this.priceNew,{})
                  .subscribe(
                    data => {
                        console.log('PUT Request is successful', data);
                    },
                    error => {
                        console.log('Error', error);
                    }
                  );
                  alert("ระบบได้บันทึกข้อมูลเรียบร้อยแล้วค่ะ");
                  //window.location.reload()
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
