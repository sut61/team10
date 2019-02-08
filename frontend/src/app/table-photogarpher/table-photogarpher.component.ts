import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import{Controller}from'../controller/controller';
import {ActivatedRoute} from "@angular/router";
@Component({
  selector: 'app-table-photogarpher',
  templateUrl: './table-photogarpher.component.html',
  styleUrls: ['./table-photogarpher.component.css']
})
export class TablePhotogarpherComponent implements OnInit {
  data:any={}
  constructor(private router:Router,
              private controller:Controller,
              private httpClient: HttpClient,
              private route:ActivatedRoute) { }

  photos: Array<any>;
  photoSelect=null;
  tel:Array<any>;
  telSelect=null;
  typephotos: Array<any>;
  typephotoSelect=null;
  timetable: Array<any>;
  timetableSelect=null;
  promotiontable: Array<any>;
  promotiontableSelect=null;
  location:Array<any>;
  locationSelect=null;
  tabledate=null;
  tablephotographer:Array<any>;





  ngOnInit() {

      this.controller.getPhotographer().subscribe(data => {
        this.photos = data;
        console.log(this.photos);
      });
      this.controller.getTypePhoto().subscribe(data => {
        this.typephotos = data;
        console.log(this.typephotos);
      });
      this.controller.getTimeTable().subscribe(data => {
        this.timetable = data;
        console.log(this.timetable);
      });
      this.controller.getPromotionTable().subscribe(data => {
        this.promotiontable = data;
        console.log(this.promotiontable);
      });
      this.controller.getTablePhotogarpher().subscribe(data => {
        this.tel = data;
        console.log(this.tel);
      });
      this.controller.getTablePhotogarpher().subscribe(data => {
        this.location = data;
        console.log(this.location);
      });
      this.controller.getTablePhotogarpher().subscribe(data => {
        this.tablephotographer = data;
        console.log(this.tablephotographer);
      });

      this.route.params.subscribe(prams => {
        this.data = prams;
        console.log(prams);
      });


  }


  repair(){
    this.router.navigate(['repairinvoiced',{first:this.data.first}]);
    console.log(this.data);
  }
  Phototable(){

    this.router.navigate(['table-photogarpher',{first:this.data.first}]);
    console.log(this.data);
  }

  insert() {
    if (this.photoSelect == null) {
      alert('กรุณาเลือกชื่อช่างภาพ');
    }
    if (this.telSelect == null) {
      alert('กรุณากรอก Tel');
    }
    if (this.typephotoSelect == null) {
      alert('กรุณาเลือกประเภทงาน');
    }
    if (this.timetableSelect == null) {
      alert('กรุณาเลือกเวลา');
    }
    if (this.promotiontableSelect == null) {
      alert('กรุณาเลือกโปรโมชั่น');
    }
    if (this.locationSelect == null) {
      alert('กรูณากรอก สถานที่นัดหมาย');
    }
    if (this.tabledate == null) {
      alert('กรุณาเลือกวันที่');
    } else {
      this.httpClient.post('http://localhost:8080/tablephotographer/' + this.photoSelect + '/' + this.telSelect + '/' + this.typephotoSelect + '/'
        + this.timetableSelect + '/' + this.promotiontableSelect + '/' + this.locationSelect + '/' + this.tabledate + '/' + this.data.first, {})
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);

          },
          error => {
            console.log('Error', error);
          }
        );
      alert('ระบบได้บันทึกข้อมูลเรียบร้อยแล้วค่ะ');

       window.location.reload()

    }
  }


}
