import { StepsService } from './../../../services/steps.service';
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { toast } from "angular2-materialize";
import { ActivatedRoute } from '@angular/router';
declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent implements OnInit {
  isAddingOption: boolean;
  idProject: number;
  listAllSteps: any[];
  constructor(private stepsService: StepsService,
    private activatedRoute: ActivatedRoute) {
    $(document).ready(function () {
      $(".collapsible").collapsible();
    });
    this.activatedRoute.parent.parent.params.subscribe(params => this.idProject = params.id)
  }
  ngOnInit(): void {
    this.stepsService.getListAllSteps(this.idProject).subscribe(response => {
      this.listAllSteps = response.steps;
      console.log(this.listAllSteps);
    });
  }

  saveStep(step: any) {
    this.stepsService.postAddNewOption(step, this.idProject).subscribe(response => { console.log(response.text()) }
      , error => {
        console.log(error);
      })
  }


  cancelAdding() {
    this.isAddingOption = false;
  }
}
