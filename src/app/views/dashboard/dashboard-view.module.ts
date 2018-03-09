import { RouterModule } from '@angular/router';
import { FooterComponent } from './../../components/footer/footer.component';
import { NavbarComponent } from './../../components/navbar/navbar.component';
import { SidebarComponent } from './../../components/sidebar/sidebar.component';
import { DashboardViewComponent } from './dashboard-view.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
    imports:[RouterModule,CommonModule],
  declarations: [
    DashboardViewComponent,
    SidebarComponent,
    NavbarComponent,
    FooterComponent
  ],
  exports: [DashboardViewComponent]
})
export class DashboardViewModule {}
