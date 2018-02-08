import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, Output, EventEmitter } from '@angular/core';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { toast } from "angular2-materialize";

declare const $: any;
@Component({
    selector: "app-pipeline-generator-form",
    templateUrl: "./pipeline-generator-form.component.html"
})
export class PipelineGeneratorFormComponent implements OnInit {
    form: FormGroup;
    @Output() cancelAddingEvent = new EventEmitter();
    lenguageToSelect: any[];
    dataToSentBackend: any[];
    scriptsToSelect: any[];

    ngOnInit(): void {
        //TODO: Change this for a catalog sent for backend
        this.lenguageToSelect = [{
            name: "Java"
        }, {
            name: "NodeJs"
        },
        {
            name: "Python"
        }]
        this.form.valueChanges.subscribe(val => {
            console.log(`My name is ${val}.`)
        });

        //TODO: each lenguage have diferent options
        this.scriptsToSelect = [{name: 'linter'},{name: 'compile'},{name: 'deploy'}]

        this.dataToSentBackend = [];
    }

    constructor(fb: FormBuilder) {
        $(document).ready(function () {
            $(".collapsible").collapsible();
          });
        this.form = fb.group({
            lenguage: ["", Validators.required],
            name: ["", Validators.required]
        });
    }

    cancelAdding() {
        this.cancelAddingEvent.emit();
    }

    addAction() {
        if (!this.isAlreadyAdded(this.form.value)) {
            this.dataToSentBackend.push(Object.assign({}, this.form.value));
        }
        console.log(this.dataToSentBackend);
        this.form.reset();
    }

    isAlreadyAdded(data: any): boolean {
        let found = false;
        for (let i = 0; i < this.dataToSentBackend.length; i++) {
            if (this.dataToSentBackend[i].name === data.name) {
                found = true;
                toast("Action already added", 3000);
                break;
            }
        }
        return found;
    }
}