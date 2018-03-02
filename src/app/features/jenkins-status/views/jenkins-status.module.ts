import { JenkinStatusService } from './../../../services/jenkin-status.service';
import { NgModule } from '@angular/core';

import { JenkinsStatusComponent } from './jenkins-status.component';
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [CommonModule],
    exports: [JenkinsStatusComponent],
    declarations: [JenkinsStatusComponent],
    providers: [JenkinStatusService],
})
export class JenkinsStatusModule { }
