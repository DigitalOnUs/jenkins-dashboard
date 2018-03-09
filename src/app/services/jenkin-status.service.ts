import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class JenkinStatusService {
    url: string;

    constructor(private http: Http) {
        this.url = 'https://private-8601ef-pipelinegenerator.apiary-mock.com/jenkins/proyectId/status';
     }

    getJenkinStatus(){
        return this.http.get(this.url)
            .map((response: Response) => response.json());
    }
}