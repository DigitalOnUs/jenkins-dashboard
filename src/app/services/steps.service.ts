import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import { HttpClient, HttpHeaders } from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json"
    //'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class StepsService {
  private url;
  constructor(private http: Http, private httpClient: HttpClient) {
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
    return this.http.post(this.url + '/pipeline/' + projectId, pipeline);
  }

  createConnection(projectId: string, connectionBody) {
    return this.http.post(
      this.url + '/connection/' + projectId + '/create',
      connectionBody
    );
  }

  runJenkinsJob(projectId: string) {
    return this.http.get(this.url + '/jenkins/' + projectId + '/execute-job');
  }

  getProviderConfiguration(projectId: any) {
    return this.httpClient.get(
      'https://private-anon-44de635151-pipelinegenerator.apiary-mock.com/provider/' +
        projectId
    );
  }

  createConnectionAndProviders(
    projectId: any,
    confAndProvider: any
  ): Observable<any> {
    return this.httpClient.post<any>(
      'https://private-anon-44de635151-pipelinegenerator.apiary-mock.com/provider/' + projectId + '/create-services-provider',
      confAndProvider,
      httpOptions
    );
  }
}
