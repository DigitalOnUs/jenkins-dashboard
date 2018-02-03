import { NgModule } from "@angular/core";
import { PipelineGeneratorComponent } from "./pipeline-generator.component";
import { ReactiveFormsModule } from "@angular/forms";

@NgModule({
  imports: [ReactiveFormsModule],
  declarations: [PipelineGeneratorComponent],
  exports: [PipelineGeneratorComponent]
})
export class PipelineGeneratorModule {}
