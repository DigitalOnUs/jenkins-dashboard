import { JenkinStatusService } from './../../../services/jenkin-status.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { toast } from "angular2-materialize";

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
         * Make an Http every second
         */
        this.getStatus();
        this.interval = setInterval(() => {
            this.getStatus();
        }, 1200);
    }

    ngOnDestroy() {
        /**
         * When this view is destroyed it clear every http called
         */
        if (this.interval) {
            clearInterval(this.interval);
        }
       }

    getStatus() {
        this.isGettingStatus = true;
        this.jenkinStatusService.getJenkinStatus().subscribe((response) => {
            this.status = response.status;
            this.message = response.message;
            this.isGettingStatus = false;
            toast('Jenkin Status Updated', 3000, 'rounded');
        }, (err) => {
            this.isGettingStatus = false;
            console.error(err);
        })
    }
}