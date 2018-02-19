import { StepsService } from './../../../services/steps.service';
import { Component, OnInit, EventEmitter, Output } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { toast } from "angular2-materialize";
import { ActivatedRoute } from '@angular/router';
declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent implements OnInit {
  language: any;
  isAddingOption: boolean;
  idProject: number;
  listAllSteps: any[];
  @Output() editStep = new EventEmitter();
  selectedStep: any;
  languages: any[];
  showFioriForm: boolean;

  constructor(private stepsService: StepsService,
    private activatedRoute: ActivatedRoute) {
    this.activatedRoute.parent.parent.params.subscribe(params => this.idProject = params.id)
  this.showFioriForm = false;
  }
  ngOnInit(): void {
    $(document).ready(function () {
      $(".collapsible").collapsible();
    });
    $(document).ready(function() {
      $('select').material_select();
    });

    this.languages = [{
      id: 1,
      'name': 'Fiori'
    }]
    

    this.stepsService.getListAllSteps(this.idProject).subscribe(response => {
      this.listAllSteps = response.steps;
      console.log(this.listAllSteps);
    });
  }

  saveStep(step: any) {
    console.log(step);
  }
  funCancelAdding() {
    this.selectedStep = null;
    this.isAddingOption = false;
    this.language = null;
  }
  editStepEvent(step: any){
  this.selectedStep = step; 
  }
}
