import { JenkinStatusService } from "./../../../services/jenkin-status.service";
import { Component, OnInit, OnDestroy } from "@angular/core";
import { toast } from "angular2-materialize";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-jenkins-status",
  templateUrl: "jenkins-status.component.html"
})
export class JenkinsStatusComponent implements OnInit, OnDestroy {
  isGettingStatus: boolean;
  isGettingLogs: boolean;
  status: any;
  message: any;
  interval: any;
  idProject: any;
  logs: any[];
  constructor(
    private jenkinStatusService: JenkinStatusService,
    private activatedRoute: ActivatedRoute
  ) {
    this.isGettingStatus = true;
  }

  ngOnInit() {
    this.activatedRoute.parent.parent.params.subscribe(
      params => (this.idProject = params.id)
    );
    /**
     * Make an Http every N second
     */
    this.getStatus();
    this.getJenkinsLog();
    this.interval = setInterval(() => {
      this.getStatus();
    }, 6000);
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
    this.jenkinStatusService.getJenkinStatus(this.idProject).subscribe(
      response => {
        this.status = response.status;
        this.message = response.message;
        this.isGettingStatus = false;
      },
      err => {
        this.isGettingStatus = false;
        console.error(err);
      }
    );
  }

  getJenkinsLog() {
    this.isGettingLogs = true;
    this.jenkinStatusService
      .getJenkinsLog(this.idProject)
      .subscribe(response => {
        this.isGettingLogs = false;
        this.logs = response;
        this.logs.sort(function(a, b) {
          return a.lineNumber - b.lineNumber;
        });
      }, (err: any) => this.isGettingLogs = false);
  }
}
