import { Component, OnInit } from '@angular/core';
 import {Router} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';
@Component({
  selector: 'app-repairinvoiced',
  templateUrl: './repairinvoiced.component.html',
  styleUrls: ['./repairinvoiced.component.css']
})
export class RepairinvoicedComponent implements OnInit {

  equipments : Array<any>;
  equipmentSelect=null;
  commentt : String ;
  datein = null ;
  constructor(private router:Router,
  private controller:Controller,
  private httpClient: HttpClient) { }

  ngOnInit() {

  this.controller.getEquipment().subscribe(data => {
                                this.equipments = data;
                                console.log(this.equipments);
                              });
  }

   adminhome(){
         this.router.navigate(['adminhome']);

      }


   insert(){
         if(this.equipmentSelect != null && this.commentt != null && this.datein != null ){
              this.httpClient.post('http://localhost:8080/repairinvoiced/' + this.equipmentSelect+'/' + this.commentt +'/' + this.datein + '/admin', {})
                             .subscribe(
                               data => {
                                   console.log('PUT Request is successful', data);
                               },
                               error => {
                                   console.log('Error', error);
                               }
                              );
               alert("บันทึกสำเร็จ");
               this.equipmentSelect = null ;
                     this.datein = null;
                     this.commentt = null ;

         }
         else{
            alert("กรุณาใส่ข้อมูลให้ครบ");
         }
   }

   cancel(){
      this.equipmentSelect = null ;
      this.datein = null;
      this.commentt = null ;

   }



}
