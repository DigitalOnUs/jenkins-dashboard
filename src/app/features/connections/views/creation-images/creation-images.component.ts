import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { toast } from 'angular2-materialize';
import {ActivatedRoute} from '@angular/router';
import { ImageService } from '../../../../services/image.service';
declare const $: any;

@Component({
  selector: 'app-create-image',
  templateUrl: './creation-images.component.html'
})
export class CreateImageComponent implements OnInit {
  form: FormGroup;
  projectId: number;

  constructor(private fb: FormBuilder,
              private router: ActivatedRoute,
              private imageService: ImageService) {
    this.form = fb.group({
      jenkins: ['', Validators.required],
      azure: ['', Validators.required],
      slave: ['', Validators.required],
      gerrit: ['', Validators.required],
      nexus: ['', Validators.required]
    });
  }

  ngOnInit() {
      this.router.parent.parent.params.subscribe((params) => this.projectId = params.id);
    $(document).ready(function() {
      $('ul.tabs').tabs();
    });
    //this.imageService.getListAllImages(this.projectId).subscribe((response) => console.log(response));
  }

  sendToBack(name: any) {
    switch (name) {
        case 'jenkins': {
          const obj = {
              'name': name,
              'eneabled': this.form.controls.jenkins.value
          };
          this.imageService.postNewImage(obj, this.projectId).subscribe((response) => {
              toast('Success', 3000, 'rounded');
          }
              , (err) => {
              this.form.controls.jenkins.setValue(false);
              });
        }
        break;
        case 'azure': {
            const obj = {
                'name': name,
                'eneabled': this.form.controls.azure.value
            };
            this.imageService.postNewImage(obj, this.projectId).subscribe((response) => {
                toast('Success', 3000, 'rounded');
            } , (err) => {
                toast('Failed', 3000, 'rounded');
                this.form.controls.azure.setValue(false);
            });
        }
        break;
        case 'slave': {
            const obj = {
                'name': name,
                'eneabled': this.form.controls.slave.value
            };
            this.imageService.postNewImage(obj, this.projectId).subscribe((response) => {
                toast('Success', 3000, 'rounded');
            } , (err) => {
                toast('Failed', 3000, 'rounded');
                this.form.controls.slave.setValue(false);
            });
        }
        break;
        case 'gerrit': {
            const obj = {
                'name': name,
                'eneabled': this.form.controls.gerrit.value
            };
            this.imageService.postNewImage(obj, this.projectId).subscribe((response) => {
                toast('Success', 3000, 'rounded');
            } , (err) => {
                toast('Failed', 3000, 'rounded');
                this.form.controls.gerrit.setValue(false);
            });
        }
        break;
        case 'nexus': {
            const obj = {
                'name': name,
                'eneabled': this.form.controls.nexus.value
            };
            this.imageService.postNewImage(obj, this.projectId).subscribe((response) => {
                toast('Success', 3000, 'rounded');
            } , (err) => {
                toast('Failed', 3000, 'rounded');
                this.form.controls.nexus.setValue(false);
            });
        }
        break;
    }
  }
}
