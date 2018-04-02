import { NewConnectionViewComponent } from './new-connection-view.component';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MaterializeModule } from 'angular2-materialize';
import { StepsService } from '../../../../services/steps.service';
import {
  MatStepperModule,
  MatStepperIntl,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  MatCheckboxModule,
  MatSlideToggleModule,
  MatProgressBarModule
} from '@angular/material';
import { AppComponent } from '../../../../app.component';

@NgModule({
  imports: [
    ReactiveFormsModule,
    CommonModule,
    MaterializeModule,
    FormsModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatCheckboxModule,
    MatSlideToggleModule,
    MatProgressBarModule
  ],
  declarations: [NewConnectionViewComponent],
  exports: [NewConnectionViewComponent],
  providers: [StepsService, MatStepperIntl]
})
export class NewConnectionViewModule {}
