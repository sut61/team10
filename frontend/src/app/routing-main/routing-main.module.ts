import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from '../home/home.component'
import {LoginComponent} from '../login/login.component'
import {ReservationStudioComponent} from '../reservation-studio/reservation-studio.component'
import {RegisterComponent} from '../register/register.component'

const routes: Routes = [
   {path:'',component:LoginComponent},
   {path:'home',component:HomeComponent},
   {path:'reservation-studio',component:ReservationStudioComponent},
    {path:'register',component:RegisterComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
