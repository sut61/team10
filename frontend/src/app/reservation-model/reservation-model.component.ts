import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Controller } from '../controller/controller';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";

@Component({
  selector: 'app-reservation-model',
  templateUrl: './reservation-model.component.html',
  styleUrls: ['./reservation-model.component.css']
})
export class ReservationModelComponent implements OnInit {
data:any={}


  constructor(private controller: Controller,
                            private httpClient: HttpClient,
                            private router:Router,
                            private route:ActivatedRoute) { }

  membername: Array<any>;
  membernameSelect = null;
  modelname: Array<any>;
  modelnameSelect = null;
  themes: Array<any>;
  themesSelect = null;
  location: Array<any>;
  locationSelect = null;
  promotionmodel: Array<any>;
  promotionmodelSelect = null;
  dateSelect = null;

  ngOnInit() {

    this.controller.getModel().subscribe(data => {
      this.modelname = data;
      console.log(this.modelname);
    });
    this.controller.getReservation().subscribe(data => {
      this.themes = data;
      console.log(this.themes);
    });
    this.controller.getReservation().subscribe(data => {
      this.location = data;
      console.log(this.location);
    });
    this.controller.getPromotionModel().subscribe(data => {
      this.promotionmodel = data;
      console.log(this.promotionmodel);
    });

     this.route.params.subscribe(prams=>{
                      this.data = prams
                      console.log(prams)
                    })
  }
  insert() {
    if(this.modelnameSelect == null) {alert('กรุณาเลือกชื่อนางแบบ');}
    if(this.themesSelect == null) {alert('กรุณากรอก Themes');}
    if(this.locationSelect == null) {alert('กรุณากรอก Loccation');}
    if(this.promotionmodelSelect == null) {alert('กรุณาเลือกโปรโมชั่น');} else {

      this.httpClient.post('http://localhost:8080/ReservationModels/' + this.modelnameSelect + '/' + this.themesSelect + '/' + this.locationSelect + '/' + this.promotionmodelSelect + '/' + this.dateSelect+'/'+this.data.first, {})
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);

          },
          error => {
            console.log('Error', error);
          }
        );
      alert('ระบบได้บันทึกข้อมูลเรียบร้อยแล้วค่ะ');

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
