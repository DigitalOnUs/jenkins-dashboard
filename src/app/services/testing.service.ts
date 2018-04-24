import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
    //'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class TestingService {
  private url;

  constructor(private httpClient: HttpClient) {
    this.url = 'http://54.193.81.209:8080';
  }

  setupTesting(projectId: any, confAndProvider: any): Observable<any> {
    return this.httpClient.post<any>(
      this.url + '/testing/' + projectId + '/create-setup',
      confAndProvider,
      httpOptions
    );
  }
}
