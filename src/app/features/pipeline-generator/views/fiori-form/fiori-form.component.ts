import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
    selector: 'app-fiori-form',
    templateUrl: 'fiori-form.component.html'
})

export class FioriFormComponent implements OnInit {
    form: FormGroup;
    constructor(private fb: FormBuilder) {
        this.form = fb.group({
            name: ['', Validators.required]
        });
     }

    ngOnInit() { }
}