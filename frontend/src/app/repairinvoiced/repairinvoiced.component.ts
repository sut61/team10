import { Component, OnInit } from '@angular/core';
 import {Router} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';
  import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-repairinvoiced',
  templateUrl: './repairinvoiced.component.html',
  styleUrls: ['./repairinvoiced.component.css']
})
export class RepairinvoicedComponent implements OnInit {
  repairinvoiceds : Array<any>;
  equipments : Array<any>;
  equipmentSelect=null;
  commentt : String ;
  datein = null ;
  constructor(private router:Router,
  private controller:Controller,
  private httpClient: HttpClient,
  private route:ActivatedRoute) { }

  data:any={}

  ngOnInit() {

  this.controller.getEquipment().subscribe(data => {
                                 this.equipments = data;
                                 console.log(this.equipments);
                               });
   this.controller.getRepairInvoiced().subscribe(data => {
                                  this.repairinvoiceds = data;
                                  console.log(this.repairinvoiceds);
                                });
   this.route.params.subscribe(prams=>{
                   this.data = prams
                   console.log(prams)
                 })
  }



   insert(){
         if(this.equipmentSelect != null && this.commentt != null && this.datein != null ){
              this.httpClient.post('http://localhost:8080/repairinvoiced/' + this.equipmentSelect+'/' + this.commentt +'/' + this.datein + '/' + this.data.first, {})
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
                     window.location.reload()

         }
         else{
            alert("กรุณาใส่ข้อมูลให้ครบ");
         }
   }

   cancel(){
      this.equipmentSelect = null ;
      this.datein = null;
      this.commentt = null ;
      console.log(this.data.first);

   }



}
