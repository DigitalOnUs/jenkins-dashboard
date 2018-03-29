import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { toast } from "angular2-materialize";
import { StepsService } from '../../../../services/steps.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-new-connection',
  templateUrl: './new-connection-view.component.html'
})
export class NewConnectionViewComponent implements OnInit {
  form: FormGroup;
  providers: any[];
  idProject: any;

  constructor(fb: FormBuilder,
              private stepService: StepsService,
              private activatedRoute: ActivatedRoute) {
      this.form = fb.group({
          provider: ['', Validators.required],
          accessKey: ['', Validators.required],
          secret: ['', Validators.required]
      });

  }
  ngOnInit() {
    this.activatedRoute.parent.parent.params.subscribe(params => this.idProject = params.id);
      this.providers = [{
          'id': 1,
          'name': 'Microsoft Azure'
      }, {
          'id': 2,
          'name': 'Amazon Web Services'
      }, {
          'id': 3,
          'name': 'Google Cloud'
      }];
  }

  save(){
    this.stepService.createConnection(this.idProject, this.form.value).subscribe(() => {
        toast('Save', 3000, 'rounded')
    }, (err) => {
        console.error(err);
    });
  }

}
