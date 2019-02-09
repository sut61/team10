import { Component, OnInit } from '@angular/core';
import { Controller } from '../controller/controller';

import { HttpClient} from '@angular/common/http';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";


@Component({
  selector: 'app-reservation-equipment',
  templateUrl: './reservation-equipment.component.html',
  styleUrls: ['./reservation-equipment.component.css']
})
export class ReservationEquipmentComponent implements OnInit {
 private daterent:Date

data:any={}
  equis: Array<any>;
  times: Array<any>;
  mems: Array<any>;
  equiSelect ='';
  timeSelect = '';
  memSelect = '';
  detail1 = null;
   cardid1 = null;
  constructor(private controller: Controller,
              private httpClient: HttpClient,
              private router:Router,
              private route:ActivatedRoute){}



  ngOnInit() {
    this.controller.getEquipment().subscribe(data => {
      this.equis = data;
      console.log(this.equis);
    })
    this.controller.getTimereceive().subscribe(data => {
      this.times = data;
      console.log(this.times);
    });

      this.route.params.subscribe(prams=>{
                  this.data = prams
                  console.log(prams)
                })

  }
  insert() {
         if (this.daterent == null || this.timeSelect == null|| this.equiSelect == null || this.cardid1 == null) {
                alert('กรุณากรอกข้อมูลให้ครบ');

          }
          else if((this.cardid1 as string).length != 13){
                alert("กรุณาใส่เลขบัตรประชาชนให้ครบ");
          }
          else{
    this.httpClient.post('http://localhost:8080/reservationequipment/ ' + this.daterent + '/'+ this.detail1 + '/' + this.cardid1 + '/' + this.timeSelect + '/' + this.equiSelect + '/' + this.data.first ,{})
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    alert('สำเร็จ');
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
