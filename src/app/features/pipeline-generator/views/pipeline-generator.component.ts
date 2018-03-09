import { StepsService } from './../../../services/steps.service';
import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { toast } from 'angular2-materialize';
import { ActivatedRoute } from '@angular/router';
declare const $: any;

@Component({
  selector: 'app-pipeline-generator',
  templateUrl: './pipeline-generator.component.html'
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
    $(document).ready(function () {
      $('select').material_select();
    });

    this.languages = [{
      id: 1,
      'name': 'Fiori'
    }]
    //TODO: Delete this
    this.listAllSteps = [];
  }

  saveStep(step: any) {
    if (this.selectedStep) {
      let obj = this.listAllSteps.indexOf(this.selectedStep);
      this.listAllSteps[obj] = step;
      this.selectedStep = null;
    } else {
      this.listAllSteps.push(step);
    }
    this.isAddingOption = false;
    this.language = null;
  }
  funCancelAdding() {
    this.selectedStep = null;
    this.isAddingOption = false;
    this.language = null;
  }
  editStepEvent(step: any) {
    //TODO: Delete this
    this.language = 'Fiori';
    this.selectedStep = step;
  }

  deleteStep(step: any) {
    let i = this.listAllSteps.indexOf(step);
    this.listAllSteps.splice(i);
  }
  submitPipeline(){
    //TODO: Delete FIORI HARCODE
    let obj = Object.assign({},
      {'language': 'Fiori',
        'steps': this.listAllSteps});
        toast('Success', 3000, 'rounded');
        console.log('Structure send to back -->');
    console.log(obj);
  }
}
