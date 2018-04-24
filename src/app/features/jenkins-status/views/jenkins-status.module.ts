import { JenkinStatusService } from './../../../services/jenkin-status.service';
import { NgModule } from '@angular/core';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { JenkinsStatusComponent } from './jenkins-status.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatRadioModule } from '@angular/material';

@NgModule({
  imports: [CommonModule, MatSlideToggleModule, FormsModule, MatRadioModule],
  exports: [JenkinsStatusComponent],
  declarations: [JenkinsStatusComponent],
  providers: [JenkinStatusService]
})
export class JenkinsStatusModule {}
