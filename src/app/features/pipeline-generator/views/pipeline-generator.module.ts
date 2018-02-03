import { NgModule } from "@angular/core";
import { PipelineGeneratorComponent } from "./pipeline-generator.component";
import { ReactiveFormsModule } from "@angular/forms";
import {CommonModule} from "@angular/common";
import {MaterializeModule} from "angular2-materialize";

@NgModule({
  imports: [ReactiveFormsModule, CommonModule,MaterializeModule],
  declarations: [PipelineGeneratorComponent],
  exports: [PipelineGeneratorComponent]
})
export class PipelineGeneratorModule {}
