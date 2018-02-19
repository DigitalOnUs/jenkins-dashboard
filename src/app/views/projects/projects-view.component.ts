import { Component, OnInit } from '@angular/core';
declare const $: any;
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-projects-view',
  templateUrl: './projects-view.component.html'
})
export class ProjectsViewComponent implements OnInit {
  regionToNewProjectForm: any[];
  projects: any[];
  form: FormGroup;
  //TODO: this id would get it from backed
  id: number ;

  ngOnInit(): void {
    this.id = 2;
    //TODO: Catalog from backend
    this.regionToNewProjectForm = [
      { name: 'USA' },
      { name: 'Mexico' },
      { name: 'India' }
    ];
    //TODO: Get request from backend
    this.projects = [
      {
        id: 1,
        name: 'Project 1',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium culpa doloremque eligendi et hic id, obcaecati quam sit? Accusamus consectetur cum eaque eos excepturi explicabo nesciunt pariatur quasi quisquam sint?'
      },
      {
        id: 2,
        name: 'Project 2',
        description:
          'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium culpa doloremque eligendi et hic id, obcaecati quam sit? Accusamus consectetur cum eaque eos excepturi explicabo nesciunt pariatur quasi quisquam sint?'
      }
    ];
  }

  constructor(fb: FormBuilder) {
    $(document).ready(function() {
      // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
      $('.modal').modal();
    });
    this.form = fb.group({
      name: ['', Validators.required],
      region: ['', Validators.required]
    });
  }

  addNewProject() {
    ++ this.id;
    const object = {
      id: this.id,
      description:
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium culpa doloremque eligendi et hic id, obcaecati quam sit? Accusamus consectetur cum eaque eos excepturi explicabo nesciunt pariatur quasi quisquam sint?'
    };
    'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium culpa doloremque eligendi et hic id, obcaecati quam sit? Accusamus consectetur cum eaque eos excepturi explicabo nesciunt pariatur quasi quisquam sint?';
    this.projects.push(Object.assign({}, this.form.value, object));
    this.form.reset();
  }
}
