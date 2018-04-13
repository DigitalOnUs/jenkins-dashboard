import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { toast } from 'angular2-materialize';
import { StepsService } from '../../../../services/steps.service';
import { ActivatedRoute } from '@angular/router';
import * as _ from 'underscore';

@Component({
  selector: 'app-new-connection',
  templateUrl: './new-connection-view.component.html'
})
export class NewConnectionViewComponent implements OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  testingFormGroup: FormGroup;
  idProject: any;
  saving: boolean;
  savingCorrect: boolean;
  errorSaving: boolean;
  loading: boolean;
  showPreview: boolean;
  preview: any;
  instanceIp: any;
  initialAdminPassword: any;
  providers = [
    { value: 'aws', viewValue: 'Amazon Web Services' },
    { value: 'gcp', viewValue: 'Google Cloud Platform' },
    { value: 'ms', viewValue: 'Microsoft Azure' }
  ];
  servers = [
    {value: 'sln', viewValue: 'Selenium'},
    {value: 'njs', viewValue: 'NodeJS'}
  ];
  frameworks = [
    {value: 'cbr', viewValue: 'Cucumber'},
    {value: 'jzm', viewValue: 'Jazmine'},
    {value: 'mch', viewValue: 'Moncha'},
    {value: 'ptc', viewValue: 'Protractor'}
  ];
  webdrivers = [
    {value: 'wjs', viewValue: 'WebdriverJS'},
    {value: 'cdr', viewValue: 'ChromeDriver'},
  ];
  constructor(
    private _formBuilder: FormBuilder,
    private stepService: StepsService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit() {
    this.activatedRoute.parent.parent.params.subscribe(params => {
      this.idProject = params.id;
    });
    this.firstFormGroup = this._formBuilder.group({
      provider: ['', Validators.required],
      accessKey: ['', Validators.required],
      secretKey: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      Jenkins: [false],
      Azure: [false],
      Gerrit: [false],
      Nexus: [false]
    });
    this.testingFormGroup = this._formBuilder.group({
      Server: [''],
      Framework: [''],
      WebDriver: [''],
      ServerInfo: [],
      PortInfo: []
    });
  }

  save() {
    this.saving = true;
    this.loading = true;
    this.errorSaving = false;
    const services = [];
    _.mapObject(this.secondFormGroup.value, (value, key) => {
      switch (key) {
        case 'Jenkins':
          {
            if (value) {
              let service = {
                name: key,
                enabled: value
              };
              services.push(service);
            }
          }
          break;
        case 'Azure':
          {
            if (value) {
              let service = {
                name: key,
                enabled: value
              };
              services.push(service);
            }
          }
          break;

        case 'Gerrit':
          {
            if (value) {
              let service = {
                name: key,
                enabled: value
              };
              services.push(service);
            }
          }
          break;

        case 'Nexus':
          {
            if (value) {
              let service = {
                name: key,
                enabled: value
              };
              services.push(service);
            }
          }
          break;
        default:
          break;
      }
    });
    const obj = {
      credentials: this.firstFormGroup.value,
      services: services
    };
    this.stepService
      .createConnectionAndProviders(this.idProject, obj)
      .subscribe(data => {
        this.instanceIp = data.instanceIp
        this.initialAdminPassword = data.initialAdminPassword
        this.savingCorrect = true;
        this.loading = false;
        this.errorSaving = false;
        toast('Success', 3000, 'rounded');
      }, err => (toast(err.message, 3000, 'rounded'),
      (this.loading = false), (this.errorSaving = true)));
  }
}
