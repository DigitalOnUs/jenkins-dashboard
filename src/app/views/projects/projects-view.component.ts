import { Component, OnInit } from "@angular/core";
declare const $: any;
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ProjectService } from "../../services/project.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-projects-view",
  templateUrl: "./projects-view.component.html"
})
export class ProjectsViewComponent implements OnInit {
  regionToNewProjectForm: any[];
  projects: any[];
  form: FormGroup;
  // TODO: this id would get it from backed
  id: number;

  ngOnInit(): void {
    this.id = 2;
    // TODO: Catalog from backend
    this.regionToNewProjectForm = [
      { name: "United States" },
      { name: "Mexico" },
      { name: 'India' }
    ];
    //TODO: Get request from backend
    this.projectService
      .getAllProject()
      .subscribe(projects => (this.projects = projects));
  }

  constructor(
    fb: FormBuilder,
    private projectService: ProjectService,
    private router: Router
  ) {
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
    this.projectService
      .createProject(Object.assign({}, this.form.value))
      .subscribe(project => this.projects.push(project));
    console.log(this.projects);
    this.form.reset();
  }

  goToDashboard(id: any) {
    this.projectService.getJenkinsHasPipeline(id).subscribe(response => {
      response.isCreated
        ? this.router.navigate(['projects/' + id + '/jenkins/status'])
        : this.router.navigate(['projects/' + id + '/connections/new']);
    }, (err) => this.router.navigate(['projects/' + id + '/connections/new']));
  }
}
