import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { HomeComponent } from './home/home.component';
import { RoutingMainModule } from "./routing-main/routing-main.module";
import {MatButtonModule} from '@angular/material/button';
import { LoginComponent } from './login/login.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatStepperModule} from '@angular/material/stepper';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatTabsModule} from '@angular/material/tabs';
import {ReservationStudioComponent} from './reservation-studio/reservation-studio.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatMenuModule} from '@angular/material/menu';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CreateAccountComponent } from './create-account/create-account.component';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ReservationStudioComponent,
    CreateAccountComponent
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
    MatInputModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
