import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarPagesComponent } from './navbar-pages/navbar-pages.component';
import { FooterPagesComponent } from './footer-pages/footer-pages.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    NavbarPagesComponent,
    FooterPagesComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule
  ],
  exports: [
    NavbarPagesComponent,
    FooterPagesComponent
  ]
})
export class CoreModule { }
