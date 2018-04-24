import { NgModule } from '@angular/core';
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
  MatCardModule,
  MatDividerModule
} from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterializeModule } from 'angular2-materialize';
import { CommonModule } from '@angular/common';
import { SetupTestingComponent } from './setup-testing.component';
import { TestingService } from '../../../services/testing.service';

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
    MatCardModule,
    MatDividerModule
  ],
  declarations: [SetupTestingComponent],
  exports: [SetupTestingComponent],
  providers: [TestingService, MatStepperIntl]
})
export class SetupTestingModule {}
