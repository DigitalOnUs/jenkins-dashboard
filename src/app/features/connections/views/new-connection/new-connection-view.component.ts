import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { toast } from "angular2-materialize";


@Component({
  selector: 'app-new-connection',
  templateUrl: './new-connection-view.component.html'
})
export class NewConnectionViewComponent implements OnInit {
  form: FormGroup;
  providers: any[];

  constructor(fb: FormBuilder) {
      this.form = fb.group({
          provider: ['', Validators.required],
          accessKey: ['', Validators.required],
          secret: ['', Validators.required]
      });

  }
  ngOnInit() {
      this.providers = [{
          'id': 1,
          'name': 'Azure'
      }, {
          'id': 2,
          'name': 'Amazon Web Services'
      }, {
          'id': 3,
          'name': 'Nexus'
      }];
  }

  save(){
      toast('Save', 3000, 'rounded')
  }

}
