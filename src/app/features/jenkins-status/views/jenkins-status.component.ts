import { JenkinStatusService } from './../../../services/jenkin-status.service';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
    selector: 'app-jenkins-status',
    templateUrl: 'jenkins-status.component.html'
})

export class JenkinsStatusComponent implements OnInit, OnDestroy {
    isGettingStatus: boolean;
    status: any;
    message: any;
    interval: any;
    constructor(private jenkinStatusService: JenkinStatusService) {
        this.isGettingStatus = true;
     }

    ngOnInit() { 
        /**
         * Make an Http every 
         */
        this.interval = setInterval(() => {
            this.getStatus();
        }, 1000);
    }

    ngOnDestroy() {
        /**
         * When this view is destroyed we clear every http call
         */
        if (this.interval) {
            clearInterval(this.interval);
        }
       }

    getStatus(){
        this.isGettingStatus = true;
        this.jenkinStatusService.getJenkinStatus().subscribe((response) => {
            this.status = response.status;
            this.message = response.message;
            this.isGettingStatus = false;
            console.log(this.status);
        }, (err) => {
            this.isGettingStatus = false;
            console.error(err);
        })
    }
}