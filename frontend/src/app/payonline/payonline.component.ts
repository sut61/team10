import { Component, OnInit } from '@angular/core';
import { Controller } from '../controller/controller';

import { HttpClient} from '@angular/common/http';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";
@Component({
  selector: 'app-payonline',
  templateUrl: './payonline.component.html',
  styleUrls: ['./payonline.component.css']
})
export class PayonlineComponent implements OnInit {
private card_cvv:number;
private card_id:string;

private card_name:string;
private payment_total:number;
  data:any={}
  cardtypes: Array<any>;
  cbs: Array<any>;
  rent1s: Array<any>;
  rent2s: Array<any>;
  rent3s: Array<any>;
  rent4s: Array<any>;
  rent5s: Array<any>;


  rent1Select = null;
  rent2Select = null;
  rent3Select = null;
  rent4Select = null;
  rent5Select = null;

  cardSelect = '';
  cardbankSelect ='';


    constructor(private controller: Controller,
              private httpClient: HttpClient,
              private router:Router,
              private route:ActivatedRoute){}

  ngOnInit() {
  this.controller.getReservationequipment_id().subscribe(data => {
        this.rent1s = data;
        console.log(this.rent1s);
      })
this.controller.getReservation().subscribe(data => {
        this.rent2s = data;
        console.log(this.rent2s);
      })
this.controller.getReservationStudio_id().subscribe(data => {
        this.rent3s = data;
        console.log(this.rent3s);
      })
this.controller.getReservationphotographer_id().subscribe(data => {
        this.rent4s = data;
        console.log(this.rent4s);
      })
this.controller.getPhotocollection_id().subscribe(data => {
        this.rent5s = data;
        console.log(this.rent5s);
      })
this.controller.getCardtype().subscribe(data => {
        this.cardtypes = data;
        console.log(this.cardtypes);
      })
this.controller.getCardbank().subscribe(data => {
        this.cbs = data;
        console.log(this.cbs);
      })
this.route.params.subscribe(prams=>{
                      this.data = prams
                      console.log(prams)
                    })
      ;


            }
           insert() {

       if (this.card_cvv == null || this.card_name == null|| this.cardbankSelect == null ||
        this.cardSelect == null || this.card_id == null || this.rent5Select == null|| this.rent4Select == null
         || this.rent3Select == null|| this.rent2Select == null|| this.rent1Select == null) {
              alert('กรุณากรอกข้อมูลให้ครบ');
 }
          else if((this.card_id as string).length != 16){
                alert("กรุณาใส่เลขบัตรประชาชนให้ครบ");
          }

        else if(this.payment_total < 1000) {
                 alert('กรุณากรอกราคาให้ถูกต้อง');
           }
        else if(this.payment_total > 3000) {
                 alert('กรุณากรอกราคาให้ถูกต้อง');
           }
        else{
           this.httpClient.post('http://localhost:8080/payment/ ' + this.card_cvv  + '/' + this.card_name + '/'  + this.payment_total + '/'  + this.card_id + '/' + this.cardbankSelect + '/' + this.cardSelect + '/'  + this.data.first + '/' + this.rent5Select + '/' + this.rent2Select + '/' + this.rent4Select + '/' + this.rent3Select + '/' + this.rent1Select ,{})
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
