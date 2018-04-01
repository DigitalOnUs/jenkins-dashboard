import { JenkinStatusService } from './../../../services/jenkin-status.service';
import { NgModule } from '@angular/core';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';

import { JenkinsStatusComponent } from './jenkins-status.component';
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [CommonModule,
        MatSlideToggleModule],
    exports: [JenkinsStatusComponent],
    declarations: [JenkinsStatusComponent],
    providers: [JenkinStatusService],
})
export class JenkinsStatusModule { }
