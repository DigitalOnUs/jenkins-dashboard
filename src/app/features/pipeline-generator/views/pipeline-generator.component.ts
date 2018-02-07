import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { toast } from "angular2-materialize";

declare const $: any;

@Component({
  selector: "app-pipeline-generator",
  templateUrl: "./pipeline-generator.component.html"
})
export class PipelineGeneratorComponent implements OnInit {
  form: FormGroup;
  optionsPipeline: any[];
  isAddingOption: boolean;
  dataToSentBackend: any[];
  constructor(fb: FormBuilder) {
    $(document).ready(function() {
      $(".collapsible").collapsible();
    });
    this.form = fb.group({
      name: ["", Validators.required]
    });
  }

  ngOnInit(): void {
    //TODO: ask for this structure to the backend
    this.optionsPipeline = [
      {
        name: "I.T",
        description: "Lorem ipsum dolor sit amet."
      },
      {
        name: "Compile",
        description: "Lorem ipsum dolor sit amet"
      },
      {
        name: "Deploy",
        description: "Lorem ipsum dolor sit amet."
      },{
        name: "Build",
        description: "Lorem ipsum dolor sit amet."
      },
      {
        name: "Test",
        description: "Lorem ipsum dolor sit amet."
      }
    ];
    this.dataToSentBackend = [];
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
