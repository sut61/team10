import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";

@Component({
  selector: 'app-photocollection',
  templateUrl: './photocollection.component.html',
  styleUrls: ['./photocollection.component.css']
})
export class PhotocollectionComponent implements OnInit {
startdateIDSelect = null;
data:any={}
lastdateIDSelect = null;
constructor(private photocollection: Controller,private httpClient: HttpClient,
     private router:Router,
     private route:ActivatedRoute) { }

 memberID: Array<any>;
  memberIDSelect = null;

  photoseriesID: Array<any>;
  photoseriesIDSelect = null;

  promotionphotocollectionID: Array<any>;
  promotionphotocollectionIDSelect = null;

  shootingstyleID: Array<any>;
  shootingstyleIDSelect = null;

  shootingstylenamewriteString: Array<any>;
  shootingstylenamewriteSelect = null;


  ngOnInit() {

      this.photocollection.getPhotoseriesID().subscribe(data => {
              this.photoseriesID = data;
              console.log(this.photoseriesID);
      });
      this.photocollection.getPromotionphotocollectionID().subscribe(data => {
              this.promotionphotocollectionID = data;
              console.log(this.promotionphotocollectionID);
      });
      this.photocollection.getShootingstyleID().subscribe(data => {
              this.shootingstyleID = data;
              console.log(this.shootingstyleID);
      });

      this.photocollection.getPhotocollection().subscribe(data => {
              this.shootingstylenamewriteString = data;
              console.log(this.shootingstylenamewriteString);
      });

       this.route.params.subscribe(prams=>{
                        this.data = prams
                        console.log(prams)
                      })
  }
insert(){

       if(this.photoseriesIDSelect == null) {
                  alert('กรุณาเลือกชนิดชุดถ่ายภาพ');
      }
      else if(this.shootingstyleIDSelect == null){
                  alert('กรุณาเลือกลักษณะชุดถ่ายภาพ');
      }
      else if(this.shootingstylenamewriteSelect == null){
                  alert('กรุณาเลือกลักษณะชุดถ่ายภาพเพิ่มเติม');
      }
      else if(this.promotionphotocollectionIDSelect == null){
                        alert('กรุณาเลือกโปรโมชั่น');
      }
      else if(this.startdateIDSelect == null){
                  alert('กรุณาเลือกวันเริ่มจอง');
      }
      else if(this.lastdateIDSelect == null){
                  alert('กรุณาเลือกวันสิ้นสุดการจอง');
      }
      else{
       this.httpClient.post('http://localhost:8080/photocollection/' + this.data.first + '/' + this.photoseriesIDSelect + '/'
                     + this.promotionphotocollectionIDSelect + '/' + this.shootingstyleIDSelect + '/' + this.startdateIDSelect + '/' +
                     this.lastdateIDSelect + '/' + this.shootingstylenamewriteSelect ,{})
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
