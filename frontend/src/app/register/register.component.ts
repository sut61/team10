import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  titles : Array<any>;
  titleSelect='';
  genders : Array<any>;
  genderSelect='';
  birthday = null ;

  name : string ;
  lastname : string ;
  address : string ;
  tambon : string ;
  amphoe : string ;
  province : string ;
  postcode : string ;
  tel : string ;
  email : string ;
  userid : string ;
  password1 : string ;
  password2 : string ;


  constructor(private controller:Controller,
              private httpClient: HttpClient,
              public dialog: MatDialog
              ) { }

  ngOnInit() {

      this.controller.getTitle().subscribe(data => {
                        this.titles = data;
                        console.log(this.titles);
                      });

      this.controller.getGender().subscribe(data => {
                              this.genders = data;
                              console.log(this.genders);
                            });
  }

  cancel(){
                                this.titleSelect=null;
                                this.name=null;
                                this.lastname=null;
                                this.address=null;
                                this.tambon=null;
                                this.amphoe=null;
                                this.province=null;
                                this.postcode=null;
                                this.tel=null;
                                this.email=null;
                                this.userid=null;
                                this.password1=null;
                                this.password2=null;
                                this.genderSelect=null;
                                this.birthday=null;
  }

  enter(){



    if(this.titleSelect != '' && this.name != null && this.lastname != null && this.address != null
    && this.tambon != null && this.amphoe != null && this.province != null && this.postcode != null
    && this.tel != null && this.email != null && this.userid != null && this.password1 != null
    && this.password2 != null && this.genderSelect != null && this.birthday != null){
          if(this.password1 == this.password2){
      this.httpClient.post('http://localhost:8080/member/' + this.address + '/' + this.tambon + '/' + this.amphoe + '/'+
      this.province + '/' + this.postcode +'/' + this.name +'/' + this.lastname + '/' + this.genderSelect + '/'
       + this.tel + '/' + this.birthday + '/' + this.email +'/' + this.userid +'/' + this.password1 +'/' + this.titleSelect,{}).subscribe(datap=>{
            console.log("POST SUCCESS ",datap)

             const dialogRef = this.dialog.open(SuccessDialog, {
                              width: '500px'
                            });

                            dialogRef.afterClosed().subscribe(result => {
                              console.log('The dialog was closed');

                            });

                            this.titleSelect=null;
                            this.name=null;
                            this.lastname=null;
                            this.address=null;
                            this.tambon=null;
                            this.amphoe=null;
                            this.province=null;
                            this.postcode=null;
                            this.tel=null;
                            this.email=null;
                            this.userid=null;
                            this.password1=null;
                            this.password2=null;
                            this.genderSelect=null;
                            this.birthday=null;

        },error =>{
            console.log("Error " , error)
        })
    }
    else {
        const dialogRef = this.dialog.open(PasswordnotcorrectDialog, {
                  width: '500px'
                });

                dialogRef.afterClosed().subscribe(result => {
                  console.log('The dialog was closed');

                });
                this.password1=null;
                this.password2=null;
    }}
    else{
      const dialogRef = this.dialog.open(DataemptyDialog, {
            width: '500px'
          });

          dialogRef.afterClosed().subscribe(result => {
            console.log('The dialog was closed');

          });
    }

  }

}



@Component({
  selector: 'dataempty',
  templateUrl: 'dataempty.html',
})
export class DataemptyDialog {

  constructor(
    public dialogRef: MatDialogRef<DataemptyDialog>
    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}



@Component({
  selector: 'success',
  templateUrl: 'success.html',
})
export class SuccessDialog {

  constructor(
    public dialogRef: MatDialogRef<SuccessDialog>
    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}

@Component({
  selector: 'passwordnotcorrect',
  templateUrl: 'passwordnotcorrect.html',
})
export class PasswordnotcorrectDialog {

  constructor(
    public dialogRef: MatDialogRef<PasswordnotcorrectDialog>
    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
