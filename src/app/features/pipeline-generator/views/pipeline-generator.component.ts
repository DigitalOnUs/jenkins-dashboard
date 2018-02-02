import { Component } from "@angular/core";
declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent {
  constructor() {
    $(document).ready(function() {
      $("select").material_select();
    });
  }
}
