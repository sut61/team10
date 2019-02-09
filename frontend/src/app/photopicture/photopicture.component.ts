import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";
@Component({
  selector: 'app-photopicture',
  templateUrl: './photopicture.component.html',
  styleUrls: ['./photopicture.component.css']
})
export class PhotopictureComponent implements OnInit {
data:any={}
datadateIDSelect = null;


constructor(private controller: Controller,private httpClient: HttpClient,
     private router:Router,
     private route:ActivatedRoute) { }



  photosizeID: Array<any>;
  photosizeIDSelect = null;

  phototypeID: Array<any>;
  phototypeIDSelect = null;

  datanameID: Array<any>;
  datanameIDSelect = null;



  member1: Array<any>;
  memSelect = null ;

  dataname : String ;

  tablephotopicture:Array<any>;

  ngOnInit() {

      this.controller.getPhotopictureID().subscribe(data => {
              this.datanameID = data;
              console.log(this.datanameID);
      });
      this.controller.getPhototypeID().subscribe(data => {
              this.phototypeID = data;
              console.log(this.phototypeID);
      });
      this.controller.getPhotosizeID().subscribe(data => {
              this.photosizeID = data;
              console.log(this.photosizeID);
      });

      this.controller.getMember().subscribe(data => {
              this.member1 = data;
              console.log(this.member1);
      });

      this.controller.getPhotopictureID().subscribe(data => {
              this.tablephotopicture = data;
              console.log(this.tablephotopicture);
      });

 this.route.params.subscribe(prams=>{
                   this.data = prams
                   console.log(prams)
                 })
  }

insert(){

       if(this.memSelect == null) {
                  alert('กรุณาเลือกวสมาชิก');
      }else if(this.dataname == null){
                  alert('กรุณากรอกลรายละเอียดการส่งให้ลูกค้า');
      }
      else if(this.phototypeIDSelect == null){
                  alert('กรุณาเลือกลักษณะรูปภาพ');
      }
      else if(this.photosizeIDSelect == null){
                  alert('กรุณาเลือกลsizeของรูปภาพ');
      }
      else if(this.datadateIDSelect == null){
                  alert('กรุณาเลือกเวลาที่ส่งให้ลูกค้า');
      }


      else{
       this.httpClient.post('http://localhost:8080/photopicture/'  + this.memSelect + '/'
                     + this.dataname + '/' + this.phototypeIDSelect + '/' + this.photosizeIDSelect + '/' + this.datadateIDSelect + '/' + this.data.first ,{})
                     .subscribe(
                       data => {
                           console.log('PUT Request is successful', data);
                       },
                       error => {
                           console.log('Error', error);
                       }
                      );window.location.reload()
                      alert("ระบบได้บันทึกข้อมูลเรียบร้อยแล้วค่ะ");
                        this.memSelect=null;
                        this.dataname=null;
                        this.phototypeIDSelect=null;
                        this.photosizeIDSelect=null;
                        this.datadateIDSelect=null;


                      }
  }
  Photocom(){
       this.router.navigate(['photopicture',{first:this.data.first}]);
       console.log(this.data);
  }
  repair(){
        this.router.navigate(['repairinvoiced',{first:this.data.first}]);
        console.log(this.data);
  }
  Phototable(){

    this.router.navigate(['table-photogarpher',{first:this.data.first}]);
    console.log(this.data);
  }
  reset(){
          this.memSelect=null;
          this.dataname=null;
          this.phototypeIDSelect=null;
          this.photosizeIDSelect=null;
          this.datadateIDSelect=null;
          this.data.first=null;
    }
}
