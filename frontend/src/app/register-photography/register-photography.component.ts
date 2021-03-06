import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ActivatedRoute} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import{Controller}from'../controller/controller';

@Component({
  selector: 'app-register-photography',
  templateUrl: './register-photography.component.html',
  styleUrls: ['./register-photography.component.css']
})

export class RegisterPhotographyComponent implements OnInit {

  data:any={}

  camaras : Array<any>;
  camaraSelect='';

  instructors : Array<any>;
  instructorSelect='';

  photographyTypes : Array<any>
  photographyTypeSelect='';


  skillLevels : Array<any>
  skillLevelSelect='';

  studyTimes : Array<any>
  studyTimeSelect='';

  RegisterPhotographys : Array<any>;

  message = null;


   constructor(private controller:Controller,
               private httpClient: HttpClient,
               public dialog: MatDialog,
               private route:ActivatedRoute,
               private router:Router) { }
    reset(){
        this.camaraSelect=null;
        this.instructorSelect=null;
        this.skillLevelSelect=null;
        this.photographyTypeSelect=null;
        this.studyTimeSelect=null;
        this.message = null;
     }
    insert() {
       if(this.camaraSelect != null &&
       this.instructorSelect != null &&
       this.photographyTypeSelect != null &&
       this.skillLevelSelect != null &&
       this.studyTimeSelect != null &&
       this.message != null){
                     this.httpClient.post('http://localhost:8080/registerPhotography/' + this.camaraSelect + '/' + this.instructorSelect + '/' +
                                        this.photographyTypeSelect + '/' + this.skillLevelSelect + '/' + this.studyTimeSelect + '/' + this.data.first + '/' +
                                        this.message,{})
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
               else{
                  alert("กรุณาใส่ข้อมูลให้ครบค่ะ");
               }

    }


    ngOnInit() {
        this.controller.getCamara().subscribe(data => {
              this.camaras = data;
              console.log(this.camaras);
         });
         this.controller.getInstructor().subscribe(data => {
               this.instructors = data;
               console.log(this.instructors);
          });
        this.controller.getPhotographyType().subscribe(data => {
              this.photographyTypes = data;
              console.log(this.photographyTypes);
         });
         this.controller.getSkillLevel().subscribe(data => {
               this.skillLevels = data;
               console.log(this.skillLevels);
          });
        this.controller.getStudyTime().subscribe(data => {
              this.studyTimes = data;
              console.log(this.studyTimes);
         });
         this.controller.getRegisterPhotography().subscribe(data => {
               this.RegisterPhotographys = data;
               console.log(this.RegisterPhotographys);
         });
         this.route.params.subscribe(prams=>{
               this.data = prams
               console.log(prams)
         })
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
    payment(){
             this.router.navigate(['payonline',{first:this.data.first}]);
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
