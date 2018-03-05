import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { toast } from 'angular2-materialize';
declare const $: any;
@Component({
    selector: 'app-create-image',
    templateUrl: './create-image.component.html'
})

export class CreateImageComponent implements OnInit {
    form: FormGroup;

    constructor(private fb: FormBuilder) {
        this.form = fb.group({
            jenkins: [false, Validators.required],
            azure: [false, Validators.required],
            slave: [false, Validators.required],
            garrit: [false, Validators.required],
            nexus: [false, Validators.required]
        });
    }

    ngOnInit() {
        $(document).ready(function(){
            $('ul.tabs').tabs();
          });
    }

    sendToBack(){
        toast('Success', 3000, 'rounded')
    }
}