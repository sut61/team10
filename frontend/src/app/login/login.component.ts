import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  id :string;;
  password:string;

  constructor(private controller:Controller,
              private httpClient: HttpClient,
              private router: Router,
              public dialog: MatDialog) { }

  ngOnInit() {
  }


   login(){
       this.controller.findMember(this.id,this.password).subscribe(data=>{
          console.log(data)
              if(data!=null){
               localStorage.setItem('user',JSON.stringify(data))
                   this.router.navigate(['home',{first:data.userid}]);
              }else{

                 const dialogRef = this.dialog.open(LoginfailDialog, {
                                width: '500px'
                              });

                              dialogRef.afterClosed().subscribe(result => {
                                console.log('The dialog was closed');

                              });
               localStorage.setItem('user',JSON.stringify(data))
               this.password = null ;
              }

       })
   }
   reset(){
             this.id=null;
             this.password=null;
       }

}

@Component({
  selector: 'loginfail',
  templateUrl: 'loginfail.html',
})
export class LoginfailDialog {

  constructor(
    public dialogRef: MatDialogRef<LoginfailDialog>
    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
