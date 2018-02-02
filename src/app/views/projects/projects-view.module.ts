import { ProjectsViewComponent } from './projects-view.component';
import { NgModule } from "@angular/core";
import {RouterModule} from "@angular/router";

@NgModule({
    imports: [RouterModule],
    declarations:[ProjectsViewComponent],
    exports: [ProjectsViewComponent]
})
export class ProjectsViewModule {}