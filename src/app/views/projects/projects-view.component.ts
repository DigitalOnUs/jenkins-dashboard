import { Component, OnInit } from '@angular/core';
declare const $: any;
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProjectService } from '../../services/project.service';

@Component({
  selector: 'app-projects-view',
  templateUrl: './projects-view.component.html'
})
export class ProjectsViewComponent implements OnInit {
  regionToNewProjectForm: any[];
  projects: any[];
  form: FormGroup;
  // TODO: this id would get it from backed
  id: number ;

  ngOnInit(): void {
    this.id = 2;
    // TODO: Catalog from backend
    this.regionToNewProjectForm = [
      { name: 'United States' },
      { name: 'Mexico' },
      { name: 'India' }
    ];
    //TODO: Get request from backend
    this.projectService.getAllProject()
      .subscribe(projects => this.projects = projects);
  }

  constructor(fb: FormBuilder,
    private projectService: ProjectService) {
    $(document).ready(function() {
      // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
      $('.modal').modal();
    });
    this.form = fb.group({
      name: ['', Validators.required],
      url: ['', Validators.required],
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
    this.projectService.createProject(Object.assign({}, this.form.value))
      .subscribe(project => this.projects.push(project));
    console.log(this.projects);
    this.form.reset();
  }
}
