import { DashboardRouting } from './views/dashboard/dashboard.routing';
import { ProjectsViewModule } from './views/projects/projects-view.module';
import { ProjectsViewComponent } from './views/projects/projects-view.component';
import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TableListComponent } from './table-list/table-list.component';
import { TypographyComponent } from './typography/typography.component';
import { IconsComponent } from './icons/icons.component';
import { MapsComponent } from './maps/maps.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UpgradeComponent } from './upgrade/upgrade.component';
import { LoginViewComponent } from './login/login.component';



const routes: Routes =[
    { path: '',      component: ProjectsViewComponent },
    { path: 'login',   component: LoginViewComponent },
    { path: 'table-list',     component: TableListComponent },
    { path: 'projects/:id',     loadChildren: './views/dashboard/dashboard.routing#DashboardRouting' },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'notifications',  component: NotificationsComponent },
    { path: 'project',        component: UpgradeComponent },
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes, {useHash: true}),
    ProjectsViewModule
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
