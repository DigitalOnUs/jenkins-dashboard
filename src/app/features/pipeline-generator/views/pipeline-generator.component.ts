import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { toast } from "angular2-materialize";
declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent implements OnInit {
  isAddingOption: boolean;
  constructor() {
  }
  ngOnInit(): void { }


  cancelAdding() {
    this.isAddingOption = false;
  }
}
