import { NewConnectionViewModule } from './views/new-connection/new-connection-view.module';
import { NgModule } from "@angular/core";
import { NewConnectionViewComponent } from "./views/new-connection/new-connection-view.component";
import { Routes, RouterModule } from "@angular/router";

export const ROUTES: Routes = [
  {
    path: 'new',
    component: NewConnectionViewComponent
  }
];

@NgModule({
  imports: [
      NewConnectionViewModule,
      RouterModule.forChild(ROUTES)
    ]
})
export class ConnectionsRouting {
    static routes = ROUTES; 
}
