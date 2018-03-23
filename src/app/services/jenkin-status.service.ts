import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class JenkinStatusService {
  url: string;

  constructor(private http: Http) {
    this.url = 'http://54.183.152.125:8080';
  }

  getJenkinStatus(idProject: any) {
    return this.http
      .get(this.url + '/jenkins/' + idProject + '/status')
      .map((response: Response) => response.json());
  }

  getJenkinsLog(projectID: any) {
    return this.http
      .get(this.url + projectID + '/logs')
      .map((response: Response) => response.json());
  }
}
