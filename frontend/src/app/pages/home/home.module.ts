import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { NgxBootstrapModule } from 'src/app/shared/bootstrap/ngx-bootstrap.module';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    NgxBootstrapModule
  ]
})
export class HomeModule { }
