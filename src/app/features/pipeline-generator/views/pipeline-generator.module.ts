import { StepsService } from './../../../services/steps.service';
import { NgModule } from "@angular/core";
import { PipelineGeneratorComponent } from "./pipeline-generator.component";
import { ReactiveFormsModule } from "@angular/forms";
import {CommonModule} from "@angular/common";
import {MaterializeModule} from "angular2-materialize";
import { FioriFormComponent } from './fiori-form/fiori-form.component';

@NgModule({
  imports: [ReactiveFormsModule, CommonModule, MaterializeModule],
  declarations: [PipelineGeneratorComponent,
    FioriFormComponent],
  exports: [PipelineGeneratorComponent  ],
  providers: [StepsService]
})
export class PipelineGeneratorModule {}
