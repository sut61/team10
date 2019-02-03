import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { HomeComponent } from './home/home.component';
import { RoutingMainModule } from "./routing-main/routing-main.module";
import {MatButtonModule} from '@angular/material/button';
import { LoginComponent , LoginfailDialog } from './login/login.component';
import { RegisterComponent , DataemptyDialog , PasswordnotcorrectDialog, SuccessDialog , UseralreadyDialog } from './register/register.component';
import { MatListModule} from '@angular/material';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatStepperModule} from '@angular/material/stepper';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatTabsModule} from '@angular/material/tabs';
import {ReservationStudioComponent} from './reservation-studio/reservation-studio.component';
import {ReservationEquipmentComponent} from './reservation-equipment/reservation-equipment.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatMenuModule} from '@angular/material/menu';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import { Controller } from './controller/controller';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatChipsModule} from '@angular/material/chips';
import {MatNativeDateModule} from '@angular/material';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatDialogModule} from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';
import {ReservationPhotographerComponent} from './reservation-photographer/reservation-photographer.component';
import {PhotocollectionComponent} from './photocollection/photocollection.component';
import {ReservationModelComponent} from './reservation-model/reservation-model.component';
import { RepairinvoicedComponent } from './repairinvoiced/repairinvoiced.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ReservationStudioComponent,
    ReservationEquipmentComponent,
    RegisterComponent,
    DataemptyDialog,
    SuccessDialog,
    PasswordnotcorrectDialog,
    UseralreadyDialog,
    ReservationPhotographerComponent,
    PhotocollectionComponent,
    ReservationModelComponent,
    LoginfailDialog,
    RepairinvoicedComponent
  ],

  imports: [
    BrowserModule,
    RoutingMainModule,
    MatButtonModule,
    MatTooltipModule,
    MatStepperModule,
    MatToolbarModule,
    MatCardModule,
    MatProgressBarModule,
    MatTabsModule,
    MatDividerModule,
    MatMenuModule,
    BrowserAnimationsModule,
    MatButtonToggleModule,
    MatSelectModule,
    MatInputModule,
    MatListModule,
    FormsModule,
    MatFormFieldModule,
    MatChipsModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatDialogModule,
    HttpClientModule

  ],
  providers: [Controller],
  entryComponents: [RegisterComponent, DataemptyDialog, PasswordnotcorrectDialog , SuccessDialog , UseralreadyDialog, LoginfailDialog, LoginComponent],
  bootstrap: [AppComponent]
})

export class AppModule { }
