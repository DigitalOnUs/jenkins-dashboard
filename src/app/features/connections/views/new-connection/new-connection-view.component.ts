import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { toast } from "angular2-materialize";
import { StepsService } from "../../../../services/steps.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-new-connection",
  templateUrl: "./new-connection-view.component.html"
})
export class NewConnectionViewComponent implements OnInit {
  constructor() {}
  ngOnInit() {}
}
