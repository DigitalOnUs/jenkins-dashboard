import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class ProjectService {
  private url;
  constructor(private http: Http, private httpClient: HttpClient) {
    this.url = 'http://54.193.81.209:8080';
  }

  getAllProject() {
    return this.http
      .get(this.url + '/project')
      .map((projects: Response) => projects.json());
  }

  createProject(project: any) {
    return this.http
      .post(this.url + '/project', project)
      .map((project: Response) => project.json());
  }

  getJenkinsHasPipeline(proyectId: any) {
    return this.http
      .get(this.url + proyectId + '/pipeline-created')
      .map((projects: Response) => projects.json());
  }

  getProjectName(projectId: any) {
    return this.httpClient.get(this.url + '/project/' + projectId);
  }
}
