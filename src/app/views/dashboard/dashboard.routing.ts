import { DashboardViewModule } from './dashboard-view.module';
import { DashboardViewComponent } from './dashboard-view.component';
import { NewConnectionViewModule } from './../../features/connections/views/new-connection/new-connection-view.module';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

export const ROUTES: Routes = [
  {
    path: '',
    component: DashboardViewComponent,
    children: [
      {
        path: 'connections',
        loadChildren:
          '../../features/connections/connections.routing#ConnectionsRouting'
      },
      {
        path: 'pipeline',
        loadChildren:
          '../../features/pipeline-generator/pipeline-generator.routing#PipelineGeneratorRouting'
      },
      {
        path: 'jenkins',
        loadChildren:
        '../../features/jenkins-status/jenkins-status-view.routing#JenkinsStatusRouting'
      }
    ]
  }
];
@NgModule({
  imports: [DashboardViewModule, RouterModule.forChild(ROUTES)]
})
export class DashboardRouting {
  static routes = ROUTES;
}
