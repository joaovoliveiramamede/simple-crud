import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarPagesComponent } from './navbar-pages/navbar-pages.component';
import { FooterPagesComponent } from './footer-pages/footer-pages.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';



@NgModule({
  declarations: [
    NavbarPagesComponent,
    FooterPagesComponent,
    NavbarComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule
  ],
  exports: [
    NavbarPagesComponent,
    FooterPagesComponent,
    NavbarComponent
  ]
})
export class CoreModule { }
