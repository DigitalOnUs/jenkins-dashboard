import { Output, EventEmitter } from '@angular/core';

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
    selector: 'app-fiori-form',
    templateUrl: 'fiori-form.component.html'
})

export class FioriFormComponent implements OnInit {
    form: FormGroup;
    @Output() cancelAdding = new EventEmitter;
    @Output() fioriOptions = new EventEmitter;
    constructor(private fb: FormBuilder) {
        this.form = fb.group({
            name: ['', Validators.required],
            options: this.fb.group({
                type: ['', Validators.required],
                description: ['', Validators.required],
                url: ['', Validators.required],
                proxy_type: ['', Validators.required],
                authentication: ['', Validators.required]
            })
        });
    }

    funCancelAdding() {
        this.form.reset();
        this.cancelAdding.emit();
    }

    save(){
        this.fioriOptions.emit(this.form.value);
    }

    ngOnInit() { }
}