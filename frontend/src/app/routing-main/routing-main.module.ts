import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from '../home/home.component'
import {LoginComponent} from '../login/login.component'
import {ReservationStudioComponent} from '../reservation-studio/reservation-studio.component'
import {RegisterComponent} from '../register/register.component'
import {ReservationEquipmentComponent} from '../reservation-equipment/reservation-equipment.component'
import {ReservationPhotographerComponent} from "../reservation-photographer/reservation-photographer.component";
import {PhotocollectionComponent} from "../photocollection/photocollection.component";
import {ReservationModelComponent} from '../reservation-model/reservation-model.component';

import {RepairinvoicedComponent} from "../repairinvoiced/repairinvoiced.component";
const routes: Routes = [
   {path:'',component:LoginComponent},
   {path:'home',component:HomeComponent},
   {path:'reservation-studio',component:ReservationStudioComponent},
   {path:'reservation-equipment',component:ReservationEquipmentComponent},
    {path:'register',component:RegisterComponent},
    {path:'reservation-photographer',component:ReservationPhotographerComponent},
    {path:'photocollection',component:PhotocollectionComponent},
    {path: 'reservation-model',component:ReservationModelComponent},
    {path: 'repairinvoiced',component:RepairinvoicedComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
