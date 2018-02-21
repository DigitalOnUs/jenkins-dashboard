import { Output, EventEmitter, Input } from '@angular/core';

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
    selector: 'app-fiori-form',
    templateUrl: 'fiori-form.component.html'
})

export class FioriFormComponent implements OnInit {
    form: FormGroup;
    nameOfScript: any[];
    @Output() cancelAdding = new EventEmitter;
    @Output() fioriOptions = new EventEmitter;
    @Input() stepToEdit: any;
    constructor(private fb: FormBuilder) {
        this.form = fb.group({
            name: ['', Validators.required],
            value: ['', Validators.required]
        });
    }

    funCancelAdding() {
        this.form.reset();
        this.cancelAdding.emit();
    }

    save() {
        this.fioriOptions.emit(this.form.value);
    }

    ngOnInit() {
        this.nameOfScript = [{
            'id': 'CI_DEPLOY_ACCOUNT',
            'name': 'CI Account'
        },
        {
            'id': 'TEST_DEPLOY_ACCOUNT',
            'name': 'Test Account'
        },
        {
            'id': 'PROD_DEPLOY_ACCOUNT',
            'name': 'Production Account'
        }];

        // tslint:disable-next-line:curly
        if (this.stepToEdit)
            this.form.patchValue(this.stepToEdit);
    }
}