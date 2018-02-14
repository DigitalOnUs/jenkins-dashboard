import { StepsService } from './../../../services/steps.service';
import { NgModule } from "@angular/core";
import { PipelineGeneratorComponent } from "./pipeline-generator.component";
import { ReactiveFormsModule } from "@angular/forms";
import {CommonModule} from "@angular/common";
import {MaterializeModule} from "angular2-materialize";
import { PipelineGeneratorFormComponent } from "./pipeline-generator-form.component";

@NgModule({
  imports: [ReactiveFormsModule, CommonModule, MaterializeModule],
  declarations: [PipelineGeneratorComponent, PipelineGeneratorFormComponent],
  exports: [PipelineGeneratorComponent , PipelineGeneratorFormComponent],
  providers: [StepsService]
})
export class PipelineGeneratorModule {}
