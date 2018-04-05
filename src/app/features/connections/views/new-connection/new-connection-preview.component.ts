import { Component, Input, OnInit } from "@angular/core";
import * as _ from 'underscore';

@Component({
    selector: 'app-new-connection-preview',
    templateUrl: './new-connection-preview.component.html'
  })
export class NewConnectionPreviewComponent implements OnInit {
    @Input() providerValues: any;
    @Input() servicesValues: any;
    keys: any
    filtered: any;
    ngOnInit(): void {
        this.filtered = _.pick(this.servicesValues, _.identity)
        this.filtered = Object.keys(this.filtered);
    }
}