import { LayoutComponent } from './layout.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {ROUTES} from './layout.routes';

import { FooterComponent } from '../footer/footer.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { SidebarComponent } from '../sidebar/sidebar.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    ROUTES
  ],
  declarations: [
    FooterComponent,
    NavbarComponent,
    SidebarComponent,
    LayoutComponent
  ],
  exports: []
})
export class LayoutModule { }
