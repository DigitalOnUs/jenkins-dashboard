import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import {PipelineGeneratorComponent} from "./views/pipeline-generator.component";
import {PipelineGeneratorModule} from "./views/pipeline-generator.module";

export const ROUTES: Routes = [
    {
        path: 'generator',
        component: PipelineGeneratorComponent
    }
];

@NgModule({
    imports: [
        PipelineGeneratorModule,
        RouterModule.forChild(ROUTES)
    ]
})
export class PipelineGeneratorRouting {
    static routes = ROUTES;
}
