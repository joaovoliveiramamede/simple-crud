import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PagesRoutingModule } from './pages-routing.module';
import { PagesComponent } from './pages.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CoreModule } from '../core/core.module';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    PagesComponent,
    HomePageComponent
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    CoreModule,
    SharedModule
  ]
})
export class PagesModule { }
