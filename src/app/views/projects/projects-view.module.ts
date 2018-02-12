import { ProjectsViewComponent } from "./projects-view.component";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { MaterializeModule } from "angular2-materialize";
import { CommonModule } from "@angular/common";
import { ReactiveFormsModule } from "@angular/forms";

@NgModule({
  imports: [RouterModule, MaterializeModule, CommonModule, ReactiveFormsModule],
  declarations: [ProjectsViewComponent],
  exports: [ProjectsViewComponent]
})
export class ProjectsViewModule {}
