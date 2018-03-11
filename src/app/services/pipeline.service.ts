import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class PipelineService {
  private url;
  constructor(private http: Http) {
    this.url = 'http://54.183.152.125:8080';
  }

  getPipelineStepsWithId(id: string) {
    return this.http
      .get(this.url + '/pipeline/' + id)
      .map((pipeline: Response) => pipeline.json());
  }
}
