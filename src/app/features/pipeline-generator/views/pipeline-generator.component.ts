import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent implements OnInit {
  form: FormGroup;
  optionsPipeline: any[];

  constructor(fb: FormBuilder) {
    this.form = fb.group({
      options: ["", Validators.required]
    });
  }

  ngOnInit(): void {
    this.optionsPipeline = [
      { name: "one" },
      { name: "two" },
      { name: "three" }
    ];
  }
}
