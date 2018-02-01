import { DashboardComponent } from './dashboard.component';
import { NgModule } from "@angular/core";

export const routes = [
    { path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [],
  declarations: [DashboardComponent],
  exports: []
})
export class DashboardModule {}
