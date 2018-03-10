import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { JenkinsStatusComponent } from './views/jenkins-status.component';
import { JenkinsStatusModule } from './views/jenkins-status.module';

const routes: Routes = [
  { path: 'status', component: JenkinsStatusComponent },
];

@NgModule({
  imports: [JenkinsStatusModule,
    RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class JenkinsStatusRouting {
    static routes = routes;
 }
