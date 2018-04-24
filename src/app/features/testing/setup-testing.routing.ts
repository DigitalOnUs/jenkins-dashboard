import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SetupTestingComponent } from './views/setup-testing.component';
import { SetupTestingModule } from './views/setup-testing.module';

export const ROUTES: Routes = [
  {
    path: 'testing',
    component: SetupTestingComponent
  }
];

@NgModule({
  imports: [SetupTestingModule, RouterModule.forChild(ROUTES)]
})
export class SetupTestingRouting {
  static routes = ROUTES;
}
