import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
  import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-loginwithadmin',
  templateUrl: './loginwithadmin.component.html',
  styleUrls: ['./loginwithadmin.component.css']
})
export class LoginwithadminComponent implements OnInit {

  id : String ;
  password : String
  constructor(private controller:Controller,
                            private httpClient: HttpClient,
                            private router: Router,
                            public dialog: MatDialog,
                            private route:ActivatedRoute) { }

  ngOnInit() {
  }

  login(){
         this.controller.findAdmin(this.id,this.password).subscribe(data=>{
            console.log(data)
                if(data!=null){
                 localStorage.setItem('user',JSON.stringify(data))
                     this.router.navigate(['repairinvoiced',{first:data.userid}])
                }else{
                   const dialogRef = this.dialog.open(Loginfail2Dialog, {
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
  selector: 'loginfail2',
  templateUrl: 'loginfail2.html',
})
export class Loginfail2Dialog {

  constructor(
    public dialogRef: MatDialogRef<Loginfail2Dialog>
    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
