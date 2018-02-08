import { Component, OnInit } from "@angular/core";
declare const $: any;
import swal from "sweetalert";

@Component({
  selector: "app-projects-view",
  templateUrl: "./projects-view.component.html"
})
export class ProjectsViewComponent implements OnInit {
  regionToNewProjectForm: any[];
  projects: any[];

  ngOnInit(): void {
    this.regionToNewProjectForm = [
      { name: "USA" },
      { name: "Mexico" },
      { name: "India" }
    ];

    this.projects = [
      {
        id: 1,
        name: "Project 1",
        description:
          'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium culpa doloremque eligendi et hic id, obcaecati quam sit? Accusamus consectetur cum eaque eos excepturi explicabo nesciunt pariatur quasi quisquam sint?'
      },
      {
        id: 2,
        name: "Project 2",
        description:
          'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium culpa doloremque eligendi et hic id, obcaecati quam sit? Accusamus consectetur cum eaque eos excepturi explicabo nesciunt pariatur quasi quisquam sint?'
      }
    ];
  }

  constructor() {
    $(document).ready(function() {
      // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
      $(".modal").modal();
    });
  }

  addNewProject(){
    console.log("adding new project")
  }
}
