import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent {
  form: FormGroup;

  constructor(fb: FormBuilder) {
    $(document).ready(function() {
      $("select").material_select();
    });
    this.form = fb.group({
      options: ['', Validators.required]
  });
  }
}
