import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-reservation-studio',
  templateUrl: './reservation-studio.component.html',
  styleUrls: ['./reservation-studio.component.css']
})
export class ReservationStudioComponent implements OnInit {
  roomStudios : Array<any>;
  roomStudioSelect='';

  promotionStudios : Array<any>;
  promotionStudioSelect='';

  timeStudios : Array<any>
  timeStudioSelect='';

  reservationDates = null ;


   constructor(private controller:Controller,private httpClient: HttpClient,public dialog: MatDialog) { }
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
  }
   reset(){
          this.roomStudioSelect=null;
          this.promotionStudioSelect=null;
          this.timeStudioSelect=null;
          this.reservationDates=null;
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
           else{
                this.httpClient.post('http://localhost:8080/reservationStudio/' + this.roomStudioSelect + '/' + this.promotionStudioSelect + '/'
                  + this.timeStudioSelect + '/' + this.reservationDates,{})
                  .subscribe(
                    data => {
                        console.log('PUT Request is successful', data);
                    },
                    error => {
                        console.log('Error', error);
                    }
                  );

                  alert("ระบบได้บันทึกข้อมูลเรียบร้อยแล้วค่ะ");

           }
        }

}
