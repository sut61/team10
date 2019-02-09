  import { Component, OnInit } from '@angular/core';
  import {Router} from "@angular/router";
  import {ActivatedRoute} from "@angular/router";


  @Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
  })
  export class HomeComponent implements OnInit {

   data:any={}


    constructor(private router:Router,
    private route:ActivatedRoute) { }

    ngOnInit() {

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
