import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class ProjectService {
  private url;
  constructor(private http: Http) {
    this.url = 'http://54.183.152.125:8080';
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
}
