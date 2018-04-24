import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { TestingService } from '../../../services/testing.service';
import { toast } from 'angular2-materialize';
@Component({
  selector: 'app-testing',
  templateUrl: './setup-testing.component.html'
})
export class SetupTestingComponent implements OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  idProject: any;

  constructor(
    private _formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private testingService: TestingService
  ) {}

  ngOnInit() {
    this.activatedRoute.parent.parent.params.subscribe(params => {
      this.idProject = params.id;
    });
    this.firstFormGroup = this._formBuilder.group({
      server: [''],
      cucumber: [''],
      moncha: [''],
      jasmine: ['']
    });
  }
  saveSetupTesting() {
    const obj = {
      server: '',
      services: []
    };

    if (this.firstFormGroup.controls.server.value == true)
      obj.server = 'selenium';

    if (this.firstFormGroup.controls.cucumber.value == true)
      obj.services.push('cucumber');

    if (this.firstFormGroup.controls.moncha.value == true)
      obj.services.push('moncha');

    if (this.firstFormGroup.controls.jasmine.value == true)
      obj.services.push('jasmine');

    this.testingService.setupTesting(this.idProject, obj).subscribe(
      () => {
        toast('Success', 3000, 'rounded');
      },
      err => {
        toast(err.message, 3000, 'rounded');
        console.log(err);
      }
    );
  }
}
