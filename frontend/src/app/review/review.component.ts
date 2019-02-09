import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";
import { HttpClient} from '@angular/common/http';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import{Controller}from'../controller/controller';



@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  memnames: Array<any>;
  memnameSelect=null;
  scores: Array<any>;
  scoreSelect=null;
  systems: Array<any>;
  systemSelect=null;
  pays: Array<any>;
  paySelect=null;
  commentre:String;
  commentres : Array<any>;
  topic:String;
  topics : Array<any>;
  good:String;
  dis:String;
  direc:number;
  direcs:Array<any>;
  goods:Array<any>;
  diss:Array<any>;
  data:any={}
  constructor(private controller:Controller,private httpClient: HttpClient,
              private router:Router,private route:ActivatedRoute) {}

  ngOnInit() {
    this.controller.getReview().subscribe(data => {
      this.direcs = data;
      console.log(this.direcs);
    });

    this.controller.getReview().subscribe(data => {
      this.topics = data;
      console.log(this.topics);
    });
    this.controller.getReview().subscribe(data => {
      this.goods = data;
      console.log(this.goods);
    });
    this.controller.getReview().subscribe(data => {
      this.diss = data;
      console.log(this.diss);
    });
    this.controller.getReview().subscribe(data => {
      this.commentres = data;
      console.log(this.commentres);
    });
    this.controller.getMember().subscribe(data => {
      this.memnames = data;
      console.log(this.memnames);
    });

    this.controller.getPayment().subscribe(data => {
      this.pays = data;
      console.log(this.pays);
    });

    this.controller.getSystemName().subscribe(data => {
      this.systems = data;
      console.log(this.systems);
    });

    this.controller.getScore().subscribe(data => {
      this.scores = data;
      console.log(this.scores);
    });

    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    })

  }

  enter(){
    if(this.paySelect == null || this.systemSelect == null || this.scores == null || this.commentre == null || this.topic == null
      || this.good == null || this.dis == null) {
      alert('กรุณาใส่ข้อมูลให้ครบ');
    }else{
      this.httpClient.post('http://localhost:8080/review/' +this.data.first+ '/'+ this.topic+'/'+this.paySelect
        + '/' +this.systemSelect+ '/' +this.scoreSelect+'/'+this.good+'/'+this.dis +'/'+this.commentre+'/'+this.direc,{})
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }
        );
      alert("สำเร็จ");
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
  payment(){
    this.router.navigate(['payonline',{first:this.data.first}]);
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
  registerPhotography(){
    this.router.navigate(['register-photography',{first:this.data.first}]);
    console.log(this.data);
  }
  review(){
    this.router.navigate(['review',{first:this.data.first}]);
    console.log(this.data);
  }
}



