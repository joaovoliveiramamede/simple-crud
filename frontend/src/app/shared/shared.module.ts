import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TooltipModule } from 'ngx-bootstrap/tooltip';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    TooltipModule.forRoot()
  ],
  exports: [
    TooltipModule
  ]
})
export class SharedModule { }
