import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { toast } from 'angular2-materialize';
import {ActivatedRoute} from '@angular/router';
declare const $: any;

@Component({
  selector: 'app-create-image',
  templateUrl: './create-image.component.html'
})
export class CreateImageComponent implements OnInit {
  form: FormGroup;
  projectId: number;

  constructor(private fb: FormBuilder,
              private router: ActivatedRoute) {
    this.form = fb.group({
      jenkins: [false, Validators.required],
      azure: [false, Validators.required],
      slave: [false, Validators.required],
      garrit: [false, Validators.required],
      nexus: [false, Validators.required]
    });
  }

  ngOnInit() {
      this.router.parent.parent.params.subscribe((params) => this.projectId = params.id);
    $(document).ready(function() {
      $('ul.tabs').tabs();
    });
  }

  sendToBack() {
    toast('Success', 3000, 'rounded');
  }
}
