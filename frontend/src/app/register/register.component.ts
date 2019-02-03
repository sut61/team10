import { Component, OnInit } from '@angular/core';
import{Controller}from'../controller/controller';
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

 public API = '//localhost:8080';
provinceSelect='';
  titles : Array<any>;
  members : Array<any>;
  titleSelect='';
  genders : Array<any>;
  genderSelect='';
  birthday = null ;
 provinces : Array<any>;
  name : string ;
  lastname : string ;
  address : string ;
  tambon : string ;
  amphoe : string ;

  postcode : string ;
  tel : string ;
  email : string ;
  userid : string ;
  password1 : string ;
  password2 : string ;


  constructor(private controller:Controller,
              private httpClient: HttpClient,
              public dialog: MatDialog,
               private router: Router
              ) { }

  ngOnInit() {

       this.controller.getProvince().subscribe(data => {
                              this.provinces = data;
                              console.log(this.provinces);
                            });
      this.controller.getTitle().subscribe(data => {
                        this.titles = data;
                        console.log(this.titles);
                      });

      this.controller.getGender().subscribe(data => {
                              this.genders = data;
                              console.log(this.genders);
                            });
      this.controller.getMember().subscribe(data => {
                                    this.members = data;
                                    console.log(this.members);
                                  });
  }

  cancel(){
                             this.router.navigate(['']);
  }

  enter(){


    if(this.titleSelect != '' && this.name != null && this.lastname != null && this.address != null
    && this.tambon != null && this.amphoe != null && this.provinceSelect != null && this.postcode != null
    && this.tel != null && this.email != null && this.userid != null && this.password1 != null
    && this.password2 != null && this.genderSelect != null && this.birthday != null){

          if(this.password1 == this.password2){


   this.controller.findUserid(this.userid).subscribe(data=>{
        console.log(data)
            if(data!=null){
                  const dialogRef = this.dialog.open(UseralreadyDialog, {
                                                    width: '500px'
                                                  });

                                                  dialogRef.afterClosed().subscribe(result => {
                                                    console.log('The dialog was closed');

                                                  });
                  localStorage.setItem('user',JSON.stringify(data))
                  this.userid=null ;
            }else{


              this.httpClient.post('http://localhost:8080/member/' + this.address + '/' + this.tambon + '/' + this.amphoe + '/'+
              this.provinceSelect + '/' + this.postcode +'/' + this.name +'/' + this.lastname + '/' + this.genderSelect + '/'
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
                                                                               this.provinceSelect=null;
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
                  localStorage.setItem('user',JSON.stringify(data))
                  this.router.navigate(['loginwithuser']);
            }

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
    }

    }
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
  selector: 'useralready',
  templateUrl: 'useralready.html',
})
export class UseralreadyDialog {

  constructor(
    public dialogRef: MatDialogRef<UseralreadyDialog>
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

