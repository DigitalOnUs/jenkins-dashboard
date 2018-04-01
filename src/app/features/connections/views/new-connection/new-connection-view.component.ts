import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { toast } from 'angular2-materialize';
import { StepsService } from '../../../../services/steps.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-new-connection',
  templateUrl: './new-connection-view.component.html'
})
export class NewConnectionViewComponent implements OnInit {
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  idProject: any;
  saving: boolean;
  savingCorrect: boolean;
  errorSaving: boolean;
  loading: boolean;
  providers = [
    { value: 'aws', viewValue: 'Amazon Web Services' },
    { value: 'gcp', viewValue: 'Google Cloud Platform' },
    { value: 'ms', viewValue: 'Microsoft Azure' }
  ];
  constructor(
    private _formBuilder: FormBuilder,
    private stepService: StepsService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit() {
    this.activatedRoute.parent.parent.params.subscribe(params => {
      this.idProject = params.id;
      this.stepService
        .getProviderConfiguration(params.id)
        .subscribe(data => this.firstFormGroup.patchValue(data));
    });
    this.firstFormGroup = this._formBuilder.group({
      provider: ['', Validators.required],
      accessKey: ['', Validators.required],
      secretKey: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      jenkins: [false],
      azure: [false],
      gerrit: [false],
      nexus: [false]
    });
  }

  save() {
    this.saving = true;
    this.loading = true;
    const obj = {
      credentials: this.firstFormGroup.value,
      services: this.secondFormGroup.value
    };
    console.log(obj);
    this.stepService
      .createConnectionAndProviders(this.idProject, obj)
      .subscribe(data => {
        this.savingCorrect = true;
        this.loading = false;
        console.log(data);
      }, err => (this.errorSaving = true, this.loading = false));
  }
  resetVariables(){
    this.saving = false;
  this.savingCorrect = false;
  this.errorSaving = false
  }
}
