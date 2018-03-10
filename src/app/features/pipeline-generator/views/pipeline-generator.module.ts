import { StepsService } from './../../../services/steps.service';
import { NgModule } from "@angular/core";
import { PipelineGeneratorComponent } from "./pipeline-generator.component";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import {CommonModule} from "@angular/common";
import {MaterializeModule} from "angular2-materialize";
import { FioriFormComponent } from './fiori-form/fiori-form.component';
import { PipelineService } from '../../../services/pipeline.service';

@NgModule({
  imports: [ReactiveFormsModule, CommonModule, MaterializeModule, FormsModule],
  declarations: [PipelineGeneratorComponent,
    FioriFormComponent],
  exports: [PipelineGeneratorComponent  ],
  providers: [StepsService, PipelineService]
})
export class PipelineGeneratorModule {}
