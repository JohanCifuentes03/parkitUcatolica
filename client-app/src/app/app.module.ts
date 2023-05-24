import { Component, NgModule }           from '@angular/core';
import { BrowserModule }      from '@angular/platform-browser';

import { AppComponent }       from './app.component';
import { HeaderComponent }    from './components/header/header.component';
import { FooterComponent }    from './components/footer/footer.component';
import { DirectiveComponent } from './components/directive/directive.component';
import { ClientsComponent }   from './components/clients/clients.component';
import { ClientService }      from './components/clients/client.service';
import { RouterModule,Routes }from '@angular/router';
import {HttpClientModule}     from '@angular/common/http';
import { FormComponent }      from './components/clients/form/form.component';
import { FormsModule }        from '@angular/forms';
import { OwnersComponent } from './components/owners/owners.component';
import { ParkingComponent } from './components/parkings/parking/parking.component';
import { ReserveComponent } from './components/reserves/reserve/reserve.component';



const routes: Routes = [
  {path:'', redirectTo: '/clients', pathMatch: 'full'},
  {path:'directives', component: DirectiveComponent},
  {path:'clients', component: ClientsComponent},
  {path:'owners', component: OwnersComponent},
  {path: 'parkings', component: ParkingComponent },
  {path: 'reserves', component: ReserveComponent },
  {path:'owners/form', component: FormComponent},
  {path: 'clients/form', component: FormComponent},
  {path: 'clients/form/:id', component: FormComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectiveComponent,
    ClientsComponent,
    FormComponent,
    OwnersComponent,
    ParkingComponent,
    ReserveComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule, 
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
