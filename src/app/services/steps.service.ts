import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class StepsService {
  private url;
  constructor(private http: Http) {
    this.url = 'http://54.183.152.125:8080';
  }

  getListAllSteps(id: string) {
    return this.http
      .get(this.url + '/steps/' + id)
      .map((steps: Response) => steps.json());
  }

  postAddNewOption(body: any, idProject: number) {
    return this.http.post(this.url + '/project/' + idProject, body);
  }

  createPipeline(projectId: string, pipeline: any) {
    console.log(pipeline);
    return this.http.post(this.url + '/pipeline/' + projectId, pipeline);
  }

  createConnection(projectId: string, connectionBody) {
    return this.http
      .post(this.url + '/connection/' + projectId + '/create', connectionBody)
  }
}
