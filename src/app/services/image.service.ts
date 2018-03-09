import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class ImageService {
    private url;
    constructor(private http: Http) {
        this.url = 'http://localhost:3000';
    }

    getListAllImages(id:number) {
        //TODO: Change to projectId
        return this.http.get('https://private-8601ef-pipelinegenerator.apiary-mock.com/jenkins/' + id + '/services-status')
            .map((images: Response) => images.json());
    }

    postNewImage(body: any, idProject: number) {
        return this.http.post('https://private-8601ef-pipelinegenerator.apiary-mock.com/jenkins/' + idProject + '/services-status', body);
    }

}