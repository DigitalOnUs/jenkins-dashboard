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
  MatProgressBarModule,
  MatRadioModule,
  MatIconModule,
  MatCardModule
} from '@angular/material';
import { AppComponent } from '../../../../app.component';
import { NewConnectionPreviewComponent } from './new-connection-preview.component';

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
    MatProgressBarModule,
    MatRadioModule,
    MatIconModule,
    MatCardModule
  ],
  declarations: [NewConnectionViewComponent,NewConnectionPreviewComponent],
  exports: [NewConnectionViewComponent,NewConnectionPreviewComponent],
  providers: [StepsService, MatStepperIntl]
})
export class NewConnectionViewModule {}
