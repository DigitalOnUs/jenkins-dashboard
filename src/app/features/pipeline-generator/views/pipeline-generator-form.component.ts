import { StepsService } from './../../../services/steps.service';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
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
    @Output() addNewOption = new EventEmitter();
    lenguageToSelect: any[];
    dataToSentBackend: any[];
    scriptsToSelect: any[];
    frameworkOptions: any[] = [];

    ngOnInit(): void {
        //TODO: Change this for a catalog sent for backend
        this.lenguageToSelect = [{
            name: "Java"
        }, {
            name: "NodeJs"
        }]
        this.form.get('lenguage').valueChanges.subscribe(val => {
            switch (val) {
                case 'Java': this.scriptsToSelect = [{ name: 'linterJAVA' }, { name: 'compileJAVA' }, { name: 'deployJAVA' }]
                    break;
                case 'NodeJs': this.scriptsToSelect = [{ name: 'linterNodeJs' }, { name: 'compileNodeJs' }, { name: 'deployNodeJs' }]
                    break;
            }
        });

        //TODO: each lenguage have diferent options

        this.dataToSentBackend = [];
    }

    constructor(private fb: FormBuilder) {
        this.form = fb.group({
            name: ['', Validators.required],
            lenguage: ["", Validators.required],
            options: fb.array([this.initItemRows()])
        });
    }

    initItemRows() {
        return this.fb.group({
            // list all your form controls here, which belongs to your form array
            framework: ['']
        });
    }

    createItem(): FormGroup {
        return this.fb.group({
            name: '',
            description: '',
            price: ''
        });
    }

    addNewRow() {
        // control refers to your formarray
        const control = <FormArray>this.form.controls['options'];
        // add new formgroup
        control.push(this.initItemRows());
    }

    deleteRow(index: number) {
        // control refers to your formarray
        const control = <FormArray>this.form.controls['options'];
        // remove the chosen row
        control.removeAt(index);
    }

    cancelAdding() {
        this.cancelAddingEvent.emit();
    }

    addAction() {
        this.addNewOption.emit(this.form.value);
        this.cancelAdding();
    }

    // TODO: Check if this code is necessary
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