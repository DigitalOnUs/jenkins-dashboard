import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
// noinspection TypeScriptValidateTypes
const routes: Routes = [
  { path: 'proyect', component: LayoutComponent, children: [
    { path: '', redirectTo: 'proyect', pathMatch: 'full' },
    { path: 'dashboard', loadChildren: '../../dashboard/dashboard.module#DashboardModule' }
  ]}
];

export const ROUTES = RouterModule.forChild(routes);
