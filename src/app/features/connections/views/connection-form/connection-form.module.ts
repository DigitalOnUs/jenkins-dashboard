
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { MaterializeModule } from "angular2-materialize";
import { StepsService } from "../../../../services/steps.service";
import { MatStepperModule, MatStepperIntl } from "@angular/material";
import { ConnectionFormComponent } from "./connection-form.component";


@NgModule({
  imports: [
    ReactiveFormsModule,
    CommonModule,
    MaterializeModule,
    FormsModule,
    MatStepperModule
  ],
  declarations: [ConnectionFormComponent],
  exports: [ConnectionFormComponent],
  providers: [StepsService]
})
export class ConnectionFormModule {}