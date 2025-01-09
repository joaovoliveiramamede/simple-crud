import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { TooltipModule } from 'ngx-bootstrap/tooltip';

@NgModule({
    imports: [
        TooltipModule.forRoot(),
        CommonModule
    ],
    exports: [
        TooltipModule
    ]
})
export class NgxBootstrapModule {}