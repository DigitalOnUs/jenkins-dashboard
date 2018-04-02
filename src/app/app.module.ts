import { NewConnectionViewComponent } from './features/connections/views/new-connection/new-connection-view.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { MaterializeModule } from 'angular2-materialize';
import { MatStepperModule, MatStepperIntl, MatFormFieldModule, MatInputModule, MatSelectModule, MatProgressBarModule } from "@angular/material";
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TableListComponent } from './table-list/table-list.component';
import { TypographyComponent } from './typography/typography.component';
import { IconsComponent } from './icons/icons.component';
import { MapsComponent } from './maps/maps.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UpgradeComponent } from './upgrade/upgrade.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginViewComponent } from './login/login.component';
import { LoginModule } from './login/login.component.module';
import { HttpClientModule } from '@angular/common/http'
import { NgProgressModule } from '@ngx-progressbar/core';
import { NgProgressHttpModule } from '@ngx-progressbar/http';

//firebase
import { AngularFireModule } from 'angularfire2';
import { environment } from 'environments/environment';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AuthGuard } from './services/auth-guard.service';
import { AuthService } from './services/auth.service';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TableListComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    HttpClientModule,
    ComponentsModule,
RouterModule,
    AppRoutingModule,
    MaterializeModule,
    FormsModule,
      MaterializeModule,
      MatStepperModule,
      BrowserAnimationsModule,
      LoginModule,
      AngularFireModule.initializeApp(environment.firebase),
      AngularFireAuthModule, // imports firebase/auth, only needed for auth features
      MatFormFieldModule,
      MatStepperModule,
      MatFormFieldModule,
      MatInputModule,
      MatSelectModule,
      MatProgressBarModule,
      NgProgressModule.forRoot(),
      NgProgressHttpModule
  ],
  providers: [AuthService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
